package com.rm13.cloud.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/11
 */
@Component
public class HelloBean {


    private String hello;

    public void getHello(){
        System.out.println("=======getHello=======");
        System.out.println(hello);
    }

    @Value("${hello:}")
    public void setHello( String hello) {
        this.hello = hello;
    }
}
