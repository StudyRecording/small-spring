package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.BeanException;
import org.hpc.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: small-spring
 * @ClassName SimpleInstantiationStrategy
 * @description: jdk实例化
 * @author: hpc
 * @create: 2023-04-22 17:11
 * @Version 1.0
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();

        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
           throw new BeanException("实例化Bean[" + clazz.getName() + "]失败:", e);
        }

    }
}
