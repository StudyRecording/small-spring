package org.hpc.springframework.core.io;

/**
 * @program: small-spring
 * @ClassName ResourceLoader
 * @description:资源加载器接口定义
 * @author: hpc
 * @create: 2023-04-25 21:11
 * @Version 1.0
 **/
public interface ResourceLoader {
    /**
     * @author hpc
     * @description 加载路径前缀
     **/
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
