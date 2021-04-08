package com.rm13.learn.mybatisplus.generator.user.service.impl;

import com.rm13.learn.mybatisplus.generator.user.entity.User;
import com.rm13.learn.mybatisplus.generator.user.mapper.UserMapper;
import com.rm13.learn.mybatisplus.generator.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lovemyrm13
 * @since 2021-04-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
