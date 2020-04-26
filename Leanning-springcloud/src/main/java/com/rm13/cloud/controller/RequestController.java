package com.rm13.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/14
 */
@Slf4j
@RestController
@RequestMapping("/req")
public class RequestController {

    @RequestMapping("/demo")
    public String req(HttpServletRequest request){
        final Object snmt = request.getAttribute("snmt");
        final String requestURI = request.getRequestURI();
        log.info("requestURI:"+requestURI);
        final String requestURL = request.getRequestURL().toString();
        log.info("requestURL:"+requestURL);
        return "ok";
    }
}
