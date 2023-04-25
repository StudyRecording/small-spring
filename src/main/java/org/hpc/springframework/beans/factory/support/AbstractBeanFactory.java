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

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        // 从缓存中获取
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        // 创建并获取
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }
}
