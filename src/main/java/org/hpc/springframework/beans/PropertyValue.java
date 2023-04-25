package org.hpc.springframework.beans;

/**
 * @program: small-spring
 * @ClassName PropertyValue
 * @description:
 * @author: hpc
 * @create: 2023-04-24 21:04
 * @Version 1.0
 **/
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }


}
