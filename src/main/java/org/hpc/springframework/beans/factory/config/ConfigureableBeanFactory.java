package org.hpc.springframework.beans.factory.config;

import org.hpc.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @program: small-spring
 * @ClassName ConfigureableBeanFactory
 * @description:
 * @author: hpc
 * @create: 2023-04-25 21:05
 * @Version 1.0
 **/
public interface ConfigureableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
}
