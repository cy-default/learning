package com.rm13.shardingsphere.service.impl;

import com.rm13.shardingsphere.dao.UserDAO;
import com.rm13.shardingsphere.model.po.User;
import com.rm13.shardingsphere.model.query.UserQuery;
import com.rm13.shardingsphere.model.vo.UserVO;
import com.rm13.shardingsphere.service.UserService;
import com.rm13.shardingsphere.util.BeanCopierUtil;
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
    public List<UserVO> list(UserQuery query) {
        List<User> users = userDAO.list(query);
        List<UserVO> userVOS = BeanCopierUtil.convert(users, UserVO.class);
        return userVOS;
    }

    @Override
    public UserVO get(Integer id) {
        User user = userDAO.selectByPrimaryKey(id);
        UserVO userVO = BeanCopierUtil.convert(user, UserVO.class);
        return userVO;
    }
}
