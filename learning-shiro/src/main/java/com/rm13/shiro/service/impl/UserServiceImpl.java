package com.rm13.shiro.service.impl;

import com.rm13.shiro.convertor.AbstractUserConvertor;
import com.rm13.shiro.mapper.dao.UserDao;
import com.rm13.shiro.model.bo.UserBO;
import com.rm13.shiro.model.generator.User;
import com.rm13.shiro.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final AbstractUserConvertor userConvertor;

    @Override
    public UserBO selectByPrimaryKey(Integer id) {
        final User user = userDao.selectByPrimaryKey(id);
        final UserBO userBO = userConvertor.doToBo(user);
        return userBO;
    }

    @Override
    public UserBO selectByUserName(String username) {
        final User user = userDao.selectByUserName(username);
        final UserBO userBO = userConvertor.doToBo(user);
        return userBO;
    }

    @Override
    public List<UserBO> selectAll() {
        final List<User> users = userDao.selectAll();
        final List<UserBO> userBOS = userConvertor.dosToBos(users);
        return userBOS;
    }
}
