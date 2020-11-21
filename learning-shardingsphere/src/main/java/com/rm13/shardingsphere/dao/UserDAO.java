package com.rm13.shardingsphere.dao;

import com.rm13.shardingsphere.dao.base.UserMapper;
import com.rm13.shardingsphere.po.User;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
public interface UserDAO extends UserMapper {

    List<User> listUser();
}
