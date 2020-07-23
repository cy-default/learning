package com.rm13.cloud;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/23
 */
public class ReferenceTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("aa");
        System.out.println(sb.toString());
        cc(sb);
        System.out.println(sb.toString());
        System.out.println("=========");
        String sd = "sd";
        dd(sd);
        System.out.println(sd);
    }

    static void cc(StringBuilder sb){
        System.out.println(sb.toString());
        sb.append("cc");
        System.out.println(sb.toString());
    }

    static void dd(String sb){
        System.out.println(sb);
        sb = sb+"dd";
        System.out.println(sb);
    }
}
