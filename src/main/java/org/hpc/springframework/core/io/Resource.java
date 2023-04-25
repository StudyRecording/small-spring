package org.hpc.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: small-spring
 * @ClassName Resource
 * @description: 资源加载接口定义
 * @author: hpc
 * @create: 2023-04-25 21:11
 * @Version 1.0
 **/
public interface Resource {

    InputStream getInputStream() throws IOException;
}
