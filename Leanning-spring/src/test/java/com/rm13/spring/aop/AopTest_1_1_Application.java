package com.rm13.spring.aop;

import com.rm13.spring.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Advice， 只能控制到类的级别
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class AopTest_1_1_Application {

    public static void main(String[] args) {
        // 启动 spring 的 iOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aopTest_1_1.xml");

        // 我们这里要取 AOP代理: userServiceProxy
        UserService userService = (UserService) context.getBean("userServiceProxy");
        userService.createUser("love", "rm13", 30);
        userService.queryUser();
    }
}
