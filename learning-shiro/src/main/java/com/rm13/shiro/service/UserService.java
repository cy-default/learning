package com.rm13.shiro.service;

import com.rm13.shiro.model.bo.UserBO;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    UserBO selectByPrimaryKey(Integer id);

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    UserBO selectByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<UserBO> selectAll();

}
