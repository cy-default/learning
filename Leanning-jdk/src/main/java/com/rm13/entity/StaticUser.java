package com.rm13.entity;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-12
 */
@Data
public class StaticUser {

    private String name;
    private String address;
    private static int age;

    static{
        System.out.println("StaticUser static age="+age);
    }

    public StaticUser() {
        System.out.println("StaticUser 实例化");
    }

    public StaticUser(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
