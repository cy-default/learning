package com.rm13.springboot.security;

import com.rm13.springboot.domain.User;
import com.rm13.springboot.exception.AuthenticationException;
import com.rm13.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Slf4j
@Component
public class UserSecurity {

    @Autowired
    private static UserService userService;
    /**
     * threadLocal 在拦截器afterComplete中必须调用remove方法；规避outofmemory
     */
    public static ThreadLocal<String> unionId = new ThreadLocal<>();
    public static ThreadLocal<User> user = new ThreadLocal<>();

    /**
     * 获取当前用户
     * @return
     */
    public static User currentUser(){
        String union = unionId.get();
        if(StringUtils.isBlank(union)){
            throw new AuthenticationException();
        }
        if(user.get()==null){
            User user = userService.currentUser(union);
            if(user == null){
                throw new AuthenticationException();
            }
            return user;
        }else{
            return user.get();
        }
    }
}
