package org.hpc.springframework.test.bean;

public class UserService {

//    private String name;
    private String uId;

    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //    @Override
//    public String toString() {
//        return "UserService{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
