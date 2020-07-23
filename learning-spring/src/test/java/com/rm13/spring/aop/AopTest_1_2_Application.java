package com.rm13.spring.aop;

import com.rm13.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * advisor， 能控制到方法的级别
 * advisor 内部有一个 advice。advisor 负责匹配方法，内部的 advice 负责实现方法包装。
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class AopTest_1_2_Application {

    public static void main(String[] args) {
        // 启动 spring 的 iOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aopTest_1_2.xml");

        // 我们这里要取 AOP代理: userServiceProxy
        UserService userService = (UserService) context.getBean("userServiceProxy");
        userService.createUser("love", "rm13", 30);
        userService.queryUser();
    }
}
