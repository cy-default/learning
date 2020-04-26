package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/6
 */
public class StringTest {

    public static void main(String[] args) {
        // utf-8编码下一个字符占3个字节
        String result = "好";
        System.out.println(result.getBytes().length);

        String s0 = "a";
        String s1="abc";
        String s2 = "a"+"b" +"c";
        String s3 = s0 +"bc";
        System.out.println(s3==s2);
        System.out.println(s1==s2);

    }
}


/*
public class StringTest
{

    public StringTest()
    {
    }

    public static void main(String args[])
    {
        String result = "\u597D";
        System.out.println(result.getBytes().length);
        String s0 = "a";
        String s1 = "abc";
        String s2 = "abc";
        String s3 = (new StringBuilder()).append(s0).append("bc").toString();
        System.out.println(s3 == s2);
        System.out.println(s1 == s2);
    }
}
 */