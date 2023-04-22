package org.hpc.springframework.beans.factory.support;

import org.hpc.springframework.beans.BeanException;
import org.hpc.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: small-spring
 * @ClassName DefaultListableBeanFactory
 * @description:
 * @author: hpc
 * @create: 2023-04-22 16:17
 * @Version 1.0
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeanException("不存在名字为:" + beanName + "的beanDefinition");
        }
        return beanDefinition;

    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
