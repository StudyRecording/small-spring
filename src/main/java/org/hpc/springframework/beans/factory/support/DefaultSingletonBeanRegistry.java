package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: small-spring
 * @ClassName DefaultSingletonBeanRegistry
 * @description: 实现获取和注册单例对象的方法
 * @author: hpc
 * @create: 2023-04-22 16:17
 * @Version 1.0
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
