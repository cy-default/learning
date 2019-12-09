package com.rm13.classloader;


import java.util.Random;


/**
 * 接口中定义的变量默认都是 public static final
 * 默认都是常量
 */
public class ClassLoaderTest6 {

    public static void main(String[] args) {

        System.out.println(Child6.b);
    }


}

interface Parent6{

    public static final int a = 5;
}

interface Child6 extends Parent6{
    public static final int b = new Random().nextInt();
}


