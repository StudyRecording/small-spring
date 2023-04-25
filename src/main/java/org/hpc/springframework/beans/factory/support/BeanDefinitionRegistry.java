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

    /**
     * 向注册表中注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询BeanDefinition
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
