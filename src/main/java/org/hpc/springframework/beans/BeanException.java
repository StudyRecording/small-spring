package org.hpc.springframework.beans;

/**
 * @program: small-spring
 * @ClassName BeanException
 * @description:
 * @author: hpc
 * @create: 2023-04-22 16:14
 * @Version 1.0
 **/
public class BeanException extends RuntimeException{

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
