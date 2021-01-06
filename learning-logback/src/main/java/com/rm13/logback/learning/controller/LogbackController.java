package com.rm13.logback.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/6
 */
@RestController
@RequestMapping("/logback")
public class LogbackController {

    Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @RequestMapping("/test")
    public String test(){
        logger.info("logback test :{}", UUID.randomUUID().toString().replaceAll("-",""));
        return "test";
    }
}
