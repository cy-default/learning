package com.rm13.spring.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-06
 */
@Slf4j
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        log.info("Cat...constructor...");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Cat...DisposableBean...");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Cat...InitializingBean...");
    }
}
