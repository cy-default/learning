package com.rm13.base.enums;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-04
 */
public enum  EnumDemo {
    /**
     * ONE
     */
    ONE("code1","name1"),

    /**
     * TWO
     */
    TWO("code2","name2");
    private String code;
    private String name;


    EnumDemo(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

