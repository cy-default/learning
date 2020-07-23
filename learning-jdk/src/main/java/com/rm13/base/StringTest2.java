package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/1
 */
public class StringTest2 {

    public static void main(String[] args) {
        // String str2 = (new StringBuilder()).append(new String("str")).append(new String("01")).toString();
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);

        String str3 = new String("str01");
        str3.intern();
        String str4 = "str01";
        System.out.println(str3 == str4);
    }


}
