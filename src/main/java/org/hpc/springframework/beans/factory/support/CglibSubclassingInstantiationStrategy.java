package org.hpc.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.hpc.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @program: small-spring
 * @ClassName CglibSubclassingInstantiationStrategy
 * @description: Cglib实例化
 * @author: hpc
 * @create: 2023-04-22 17:10
 * @Version 1.0
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        if (ctor != null) {
            return enhancer.create(ctor.getParameterTypes(), args);
        } else {
            return enhancer.create();
        }
    }
}
