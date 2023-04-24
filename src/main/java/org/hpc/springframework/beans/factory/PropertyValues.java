package org.hpc.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: small-spring
 * @ClassName PropertyValues
 * @description: 传递Bean对象创建过程中所需要的属性信息
 * @author: hpc
 * @create: 2023-04-24 21:04
 * @Version 1.0
 **/
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
