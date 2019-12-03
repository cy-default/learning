package com.rm13.base.basetype;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-17
 */
public class StringTest {

    public static void main(String[] args) {
//        tm1();
        length();
    }

    /**
     * 字符长度判断
     */
    public static void length(){
        String result = "龠";
        System.out.println(result.getBytes().length);
        System.out.println(result.length());
        result = "；";
        System.out.println(result.getBytes().length);
        System.out.println(result.length());
        result = ",";
        System.out.println(result.getBytes().length);
        System.out.println(result.length());

    }

    /**
     * 字符串方法传递
     */
    public static void tm1(){
        String tm = "rm13";
        StringBuilder sb = new StringBuilder("rm14");
        System.out.println("tm"+tm.hashCode());
        System.out.println("sb"+sb.hashCode());
        tm2(tm, sb);
        System.out.println(tm);
    }

    public static void tm2(String tm, StringBuilder sb){
        tm = tm + " rm";
        sb.append(" rm");
        System.out.println("tm"+tm.hashCode());
        System.out.println("sb"+sb.hashCode());
    }


}
