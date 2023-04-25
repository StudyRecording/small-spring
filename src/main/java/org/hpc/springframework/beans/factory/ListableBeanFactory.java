package org.hpc.springframework.beans.factory;

import java.util.Map;

/**
 * @program: small-spring
 * @ClassName ListableBeanFactory
 * @description:
 * @author: hpc
 * @create: 2023-04-25 21:09
 * @Version 1.0
 **/
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回Bean实例
     * @param type
     * @return
     * @param <T>
     */
    <T> Map<String, T> getBeansOfType(Class<T> type);

    /**
     * 返回注册表中所有的Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
