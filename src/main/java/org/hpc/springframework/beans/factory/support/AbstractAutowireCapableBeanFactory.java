package org.hpc.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.hpc.springframework.beans.BeanException;
import org.hpc.springframework.beans.PropertyValue;
import org.hpc.springframework.beans.PropertyValues;
import org.hpc.springframework.beans.factory.config.BeanDefinition;
import org.hpc.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @program: small-spring
 * @ClassName AbstractAutowireCapableBeanFactory
 * @description: 实例化bean
 * @author: hpc
 * @create: 2023-04-22 16:16
 * @Version 1.0
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);

            // 属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeanException("实例化Bean失败", e);
        }

        registerSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;

        // 获取可以实例化的构造方法
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);

    }

    /**
     * @author hpc
     * @description bean对象属性填充
     **/
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());

            }
            BeanUtil.setFieldValue(bean, name, value);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
