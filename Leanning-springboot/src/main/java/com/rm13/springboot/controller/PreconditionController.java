package com.rm13.springboot.controller;

import com.google.common.collect.Maps;
import com.rm13.springboot.util.PreconditionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-14
 */
@RestController
@RequestMapping("/precondition")
public class PreconditionController {

    @RequestMapping("/login")
    public Map<String, Object> login(String userName, String password){
        Map<String, Object> rootJson = Maps.newHashMap();
        PreconditionUtil.notEmpty(userName, -1,"没有填写用户名");
        PreconditionUtil.notEmpty(password,-2,"没有输入密码");
        return null;
    }
}
