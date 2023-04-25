package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.BeanException;
import org.hpc.springframework.beans.factory.config.BeanDefinition;
import org.hpc.springframework.core.io.Resource;
import org.hpc.springframework.core.io.ResourceLoader;

/**
 * @program: small-spring
 * @ClassName BeanDefinitionReader
 * @description: BeanDefinition读取接口
 * @author: hpc
 * @create: 2023-04-25 21:06
 * @Version 1.0
 **/
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeanException;

    void loadBeanDefinition(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;
}
