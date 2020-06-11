package com.rm13.spring.ioc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Getter
@Setter
public class Blue {

    public Blue(){
        log.info("blue...constructor");
    }

    public void init(){
        log.info("blue...init...");
    }

    public void detory(){
        log.info("blue...detory...");
    }
}
