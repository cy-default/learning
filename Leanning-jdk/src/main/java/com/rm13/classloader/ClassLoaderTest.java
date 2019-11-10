package com.rm13.classloader;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-05
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        // static
        /*
        System.out.println("=====static=====");
        System.out.println(Demo.demo2);
        */
        // classloader
        /**/
        System.out.println("=====loadClass1=====");
        Class cls = ClassLoaderTest.class.getClassLoader().loadClass("com.rm13.classloader.Demo");
        System.out.println("=====loadClass2=====");
        System.out.println(cls.getName());
        System.out.println("=====loadClass3=====");
        System.out.println(cls.newInstance());



        System.out.println("=====forname1=====");
        Class cls2 = Class.forName("com.rm13.classloader.Demo");
        System.out.println("=====forname2=====");
        cls2.newInstance();
    }
}

class Demo {


    public static final Demo2 demo2 = new Demo2();
    public static final Demo3 demo3 = new Demo3();

    public Demo() {
        System.out.println("constructor demo");
    }

    {
        System.out.println("static demo");
    }
}


 class Demo2 {

    public Demo2() {
        System.out.println("constractor demo2");
    }
}
 class Demo3 {
    public Demo3() {
        System.out.println("constractor demo3");
    }
}
