package org.hpc.springframework.beans.factory.config;

/**
 * @program: small-spring
 * @ClassName BeanReference
 * @description:
 * @author: hpc
 * @create: 2023-04-24 21:03
 * @Version 1.0
 **/
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
