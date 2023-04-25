package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.core.io.DefaultResourceLoader;
import org.hpc.springframework.core.io.ResourceLoader;

/**
 * @program: small-spring
 * @ClassName AbstractBeanDefinitionReader
 * @description:
 * @author: hpc
 * @create: 2023-04-25 21:06
 * @Version 1.0
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
