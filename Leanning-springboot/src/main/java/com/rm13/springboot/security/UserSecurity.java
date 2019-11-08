package com.rm13.springboot.security;

import com.rm13.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-07
 */
@Slf4j
public class UserSecurity {

    /**
     * threadLocal 在拦截器afterComplete中必须调用remove方法；规避outofmemory
     */
    public static ThreadLocal<String> unionId = new ThreadLocal<>();
    public static ThreadLocal<User> user = new ThreadLocal<>();
}
