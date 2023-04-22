package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.BeanException;
import org.hpc.springframework.beans.factory.config.BeanDefinition;

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


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
