package com.rm13.shardingsphere.service.impl;

import com.rm13.shardingsphere.dao.UserDAO;
import com.rm13.shardingsphere.dao.base.UserMapper;
import com.rm13.shardingsphere.po.User;
import com.rm13.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> listUser() {
        List<User> users = userDAO.listUser();
        return users;
    }


    @Override
    public User getUser(Integer id) {
        User user = userDAO.selectByPrimaryKey(id);
        return user;
    }
}
