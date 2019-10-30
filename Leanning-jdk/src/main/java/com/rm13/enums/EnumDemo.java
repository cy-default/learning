package com.rm13.enums;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-04
 */
public enum  EnumDemo {
    /**
     * ONE
     */
    ONE;
    private String code;
    private String name;


    EnumDemo() {
    }

    EnumDemo(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

