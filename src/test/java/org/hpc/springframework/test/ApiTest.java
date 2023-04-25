package org.hpc.springframework.test;

import cn.hutool.core.io.IoUtil;
import org.hpc.springframework.beans.PropertyValue;
import org.hpc.springframework.beans.PropertyValues;
import org.hpc.springframework.beans.factory.config.BeanReference;
import org.hpc.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.hpc.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.hpc.springframework.core.io.DefaultResourceLoader;
import org.hpc.springframework.core.io.Resource;
import org.hpc.springframework.test.bean.UserDao;
import org.hpc.springframework.test.bean.UserService;
import org.hpc.springframework.beans.factory.config.BeanDefinition;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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


    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
//        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        Resource resource = resourceLoader.getResource("http://1.15.69.146:7001/s/pa3307");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url2() throws IOException {
//        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
//        Resource resource = resourceLoader.getResource("http://1.15.69.146:7001/s/pa3307");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
        URL url = new URL("http://1.15.69.146:7001/s/pa3307");
        URLConnection con = url.openConnection();

        InputStream inputStream = con.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


}
