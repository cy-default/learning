package com.rm13.cloud.controller;

import com.rm13.cloud.common.annotation.PassLogin;
import com.rm13.cloud.pojo.po.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/17
 */
@PassLogin
@RestController
public class SourceCodeController {

    @RequestMapping("/sc1")
    public User test1(@Valid User user,  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(user.toString());
        return user;
    }
}
