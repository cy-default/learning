package com.rm13.spring.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Dog() {
        log.info("Dog...constructor...");
    }

    @PostConstruct
    public void init(){
        log.info("Dog...@PostConstruct...");
    }

    @PreDestroy
    public void destroy(){
        log.info("Dog...@PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Dog...ApplicationContextAware...");
        this.applicationContext = applicationContext;
    }
}
