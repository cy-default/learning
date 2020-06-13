package com.rm13.spring.aop.service;

import com.rm13.spring.aop.entity.AopUser;
import org.apache.catalina.User;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class UserServiceImpl implements UserService {

    private static AopUser user = null;

    @Override
    public AopUser createUser(String firstName, String lastName, Integer age) {
        user = new AopUser();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @Override
    public AopUser queryUser() {
        return user;
    }
}
