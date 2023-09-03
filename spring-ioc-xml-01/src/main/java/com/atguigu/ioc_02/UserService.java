package com.atguigu.ioc_02;

public class UserService {


    private Integer age;

    private String name;

    private UserDao userDao;
    public UserService() {}

    public UserService(UserDao userDao, Integer age, String name) {
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
