package com.rm13.cloud.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/18
 */
@Slf4j
@RequestMapping("/log")
@RestController
public class LoggerController {

    @GetMapping("")
    public String log(){
        log.info("LoggerController Error");
        return "LoggerController";
    }
}
