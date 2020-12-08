package com.rm13.cloud.tmp;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/11/24
 */
public class MainTest {

    public static void main(String[] args) {
        System.out.println(State.ON.ordinal());
        System.out.println(SS.OFF.getValue());
    }
}


enum SS{
    OFF("onnn");
    private String value;

    SS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}