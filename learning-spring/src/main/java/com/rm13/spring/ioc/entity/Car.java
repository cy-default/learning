package com.rm13.spring.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Component
public class Car {

    public Car() {
        log.info("car...constructor...");
    }

    public void init(){
        log.info("car ... init...");
    }

    public void detory(){
        log.info("car ... detory...");
    }
}
