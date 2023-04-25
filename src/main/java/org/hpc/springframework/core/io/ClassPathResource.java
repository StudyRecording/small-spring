package org.hpc.springframework.core.io;

import cn.hutool.core.lang.Assert;
import org.hpc.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: small-spring
 * @ClassName ClassPathResource
 * @description: 类的资源加载定义
 * @author: hpc
 * @create: 2023-04-25 21:10
 * @Version 1.0
 **/
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "路径必须不为空");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + "文件不能被打开, 因为文件不存在");
        }
        return is;
    }
}
