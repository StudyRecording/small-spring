package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: small-spring
 * @ClassName BeanDefinitionRegistry
 * @description: BeanDefinition的注册定义
 * @author: hpc
 * @create: 2023-04-22 16:17
 * @Version 1.0
 **/
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
