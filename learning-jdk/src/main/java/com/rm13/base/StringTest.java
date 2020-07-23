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

        //字符串靠左，多余的地方填充_
        System.out.println(String.format("%-10s", "love").replace(' ', '_'));
        //字符串靠右，多余的地方填充_
        System.out.println(String.format("%10s", "love"));
        System.out.println(String.format("%3s", "love"));


        //数字靠右，多余的地方用0填充 stringBuilder.append(String.format("%05d", age));
        System.out.println(String.format("%05d", 20));

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