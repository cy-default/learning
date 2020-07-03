package com.rm13.wx.controller.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/29
 */
@RestController
@RequestMapping("/req")
public class RequestController {

    @GetMapping("/demo")
    public String demo(HttpServletRequest req) {
        System.out.println(req.getRequestURL());
        return req.getRequestURL().toString();
    }
}

