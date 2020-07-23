package com.rm13.spring.aop.service;

import com.rm13.spring.aop.entity.AopUser;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public interface UserService {

    AopUser createUser(String firstName, String lastName, Integer age);

    AopUser queryUser();
}
