package org.hpc.springframework.beans.factory;

import org.hpc.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂
 **/
public interface BeanFactory {



    Object getBean(String name);

    Object getBean(String name, Object... args);

    /**
     * 返回指定泛型的部队向
     * @param name bean的名称
     * @param requiredType 类型
     * @return
     * @param <T>
     */
    <T> T getBean(String name, Class<T> requiredType);

}
