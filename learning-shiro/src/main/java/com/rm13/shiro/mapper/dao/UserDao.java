package com.rm13.shiro.mapper.dao;

import com.rm13.shiro.mapper.base.UserMapper;
import com.rm13.shiro.model.bo.UserBO;
import com.rm13.shiro.model.generator.Resource;
import com.rm13.shiro.model.generator.User;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
public interface UserDao extends UserMapper {

    /**
     * 根据登陆账户查询用户信息
     * @param username
     * @return
     */
    User selectByUserName(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

}
