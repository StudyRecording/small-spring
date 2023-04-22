package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.BeanException;
import org.hpc.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: small-spring
 * @ClassName AbstractAutowireCapableBeanFactory
 * @description: 实例化bean
 * @author: hpc
 * @create: 2023-04-22 16:16
 * @Version 1.0
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("实例化Bean失败", e);
        }

        registerSingleton(beanName, bean);
        return bean;
    }
}
