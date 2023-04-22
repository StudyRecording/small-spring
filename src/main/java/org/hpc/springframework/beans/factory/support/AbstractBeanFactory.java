package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.factory.BeanFactory;
import org.hpc.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: small-spring
 * @ClassName AbstractBeanFactory
 * @description: 定义获取对象的流程
 * @author: hpc
 * @create: 2023-04-22 16:16
 * @Version 1.0
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    @Override
    public Object getBean(String name) {
        // 从缓存中获取
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        // 创建并获取
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);

    }
}
