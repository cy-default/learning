package com.rm13.entity;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-12
 */
@Data
public class InstanceUser {

    private String name;
    private String address;
    private static int age;

    static{
        System.out.println("InstanceUser static age="+age);
    }

    public InstanceUser() {
        System.out.println("InstanceUser 实例化");
    }

    public InstanceUser(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
