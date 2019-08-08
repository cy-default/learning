package com.remotes.design;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-29
 */


public enum Cc {

    /**
     * 不发送
     */
    NO((byte)0, "不发送"),

    /**
     * 待发送
     */
    WAITING((byte)1, "待发送"),

    /**
     * 已发送
     */
    PROCESSED((byte)2, "已发送");

    private Byte code;
    private String name;

    Cc(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}