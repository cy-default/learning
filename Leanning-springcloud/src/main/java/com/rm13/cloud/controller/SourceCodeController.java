package com.rm13.cloud.controller;

import com.rm13.cloud.bean.User;
import com.rm13.cloud.bean.User2;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/17
 */
@RestController
public class SourceCodeController {

    @RequestMapping("/sc1")
    public User test1(@Valid User user, User2 user2, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }
        System.out.println(user2.toString());
        System.out.println(user.toString());
        return user;
    }
}
