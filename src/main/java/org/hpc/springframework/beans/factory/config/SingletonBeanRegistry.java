package org.hpc.springframework.beans.factory.config;

/**
 * @program: small-spring
 * @InterfaceName SingletonBeanRegistry
 * @description: 定义一个注册和获取单例对象的接口
 * @author: hpc
 * @create: 2023-04-22 16:15
 * @Version 1.0
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);


    void registerSingleton(String beanName, Object singletonObject);
}
