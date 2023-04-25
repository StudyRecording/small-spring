package org.hpc.springframework.beans.factory;

import org.hpc.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.hpc.springframework.beans.factory.config.BeanDefinition;
import org.hpc.springframework.beans.factory.config.ConfigureableBeanFactory;

/**
 * @program: small-spring
 * @ClassName ConfigurableListableBeanFactory
 * @description:
 * @author: hpc
 * @create: 2023-04-25 21:08
 * @Version 1.0
 **/
public interface ConfigurableListableBeanFactory extends ConfigureableBeanFactory, ListableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName);
}
