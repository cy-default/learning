package com.rm13.cloud.controller;

import com.rm13.cloud.login.PassLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/21
 */
@PassLogin
@RestController
@RequestMapping("/param")
public class MultiParamController {

    @GetMapping("/demo1")
    public List<Long> param(@RequestParam("ids")List<Long> ids){
        return ids;
    }
}
