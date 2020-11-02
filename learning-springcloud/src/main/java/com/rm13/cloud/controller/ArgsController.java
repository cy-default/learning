package com.rm13.cloud.controller;

import com.rm13.cloud.login.passlogin.PassLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 校验args参数
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/18
 */
@PassLogin
@RestController
@RequestMapping("/args")
public class ArgsController {

    @GetMapping("/support1")
    public Integer argsTypeNotSupport(Integer num){
        return num;
    }

}
