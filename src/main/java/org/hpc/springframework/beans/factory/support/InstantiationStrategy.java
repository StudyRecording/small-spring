package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @program: small-spring
 * @ClassName InstantiationStrategy
 * @description: 实例化策略接口
 * @author: hpc
 * @create: 2023-04-22 17:11
 * @Version 1.0
 **/
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);
}
