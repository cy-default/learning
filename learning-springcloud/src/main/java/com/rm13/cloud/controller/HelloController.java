package com.rm13.cloud.controller;

import com.rm13.cloud.login.PassLogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/17
 */
@PassLogin
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${hello:}")
    private String hello;

    @GetMapping("")
    public String hello(){
        return hello;
    }
}
