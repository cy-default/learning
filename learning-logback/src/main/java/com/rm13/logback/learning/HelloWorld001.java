package com.rm13.logback.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2021/1/4
 */
public class HelloWorld001 {

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(HelloWorld001.class);
        logger.debug("hello world");
        System.out.println("hello world");
    }
}
