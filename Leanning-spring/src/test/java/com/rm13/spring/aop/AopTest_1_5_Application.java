package com.rm13.spring.aop;

import com.rm13.spring.aop.service.OrderService;
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
public class AopTest_1_5_Application {

    public static void main(String[] args) {
        // 启动 spring 的 iOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aopTest_1_5.xml");

        // 注意这里，不再需要根据代理找 bean
        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);

        userService.createUser("love", "rm13", 30);
        userService.queryUser();

        orderService.createOrder("love", "随便买点什么");
        orderService.queryOrder("love");
    }
}
