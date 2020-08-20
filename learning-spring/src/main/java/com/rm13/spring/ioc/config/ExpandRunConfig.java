package com.rm13.spring.ioc.config;

import com.rm13.spring.aop.service.UserService;
import com.rm13.spring.aop.service.UserServiceImpl;
import com.rm13.spring.ioc.service.TestService;
import com.rm13.spring.ioc.service.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/14
 */
@Configuration
public class ExpandRunConfig {
    @Bean
    public TestService testService() {
        return new TestServiceImpl();
    }

    @Bean
    public UserService userService() {
        testService();
        return new UserServiceImpl();
    }
}
