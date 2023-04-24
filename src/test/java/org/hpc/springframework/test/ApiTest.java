package org.hpc.springframework.test;

import org.hpc.springframework.beans.factory.PropertyValue;
import org.hpc.springframework.beans.factory.PropertyValues;
import org.hpc.springframework.beans.factory.config.BeanReference;
import org.hpc.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.hpc.springframework.test.bean.UserDao;
import org.hpc.springframework.test.bean.UserService;
import org.hpc.springframework.beans.factory.BeanFactory;
import org.hpc.springframework.beans.factory.config.BeanDefinition;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));



        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }


}
