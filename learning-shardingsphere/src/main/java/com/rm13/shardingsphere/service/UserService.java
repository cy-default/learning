package com.rm13.shardingsphere.service;

import com.rm13.shardingsphere.po.User;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
public interface UserService {

    /**
     * 用户列表
     * @return
     */
    List<User> listUser();

    /**
     * 用户详情
     * @param id
     * @return
     */
    User getUser(Integer id);
}
