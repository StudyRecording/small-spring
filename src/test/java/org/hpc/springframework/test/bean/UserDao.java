package org.hpc.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: small-spring
 * @ClassName UserDao
 * @description:
 * @author: hpc
 * @create: 2023-04-24 21:05
 * @Version 1.0
 **/
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "hpc");
        hashMap.put("10002", "abc");
        hashMap.put("10003", "am");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
