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

}
