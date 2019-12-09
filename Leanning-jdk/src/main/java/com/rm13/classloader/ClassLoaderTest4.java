package com.rm13.classloader;
import java.util.UUID;


/**
 * 当一个常量的值并非编译期间可以确定的， 那么其值就不会被放到调用类的常量池中，
 * 这时在程序运行时， 会调用， 主动使用这个常量所在的类，显然会导致这个类被初始化。
 */
public class ClassLoaderTest4 {

    public static void main(String[] args) {
        System.out.println(Parent4.parent);

    }


}

class Parent4{

    // 被final修饰的都是常量
    public static final String parent = UUID.randomUUID().toString();

    static {
        System.out.println("parent static block");
    }
}


