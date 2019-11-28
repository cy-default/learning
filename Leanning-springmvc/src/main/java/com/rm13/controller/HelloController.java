package com.rm13.controller;

import com.rm13.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-26
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(User user){
        return user.toString();
    }

    @RequestMapping("/hello2")
    public String hello2(User user, User user2, Map<String, String> param){
        System.out.println(user.toString());
        System.out.println(user2.toString());
        System.out.println(param.toString());
        return user.toString();
    }
}
