package com.rm13.classloader;

/**
 * 对于静态字段来说： 只有直接定义了该字段的类才会被初始化；
 * 当一个类在初始化时， 要求其父类全部都已经初始化完毕。
 *
 * -XX:+TraceClassLoading , 用于追踪类的加载信息并打印出来
 *
 * JVM参数说明：
 *  （表示开关， boolean 类型的值）
 *  -XX:+<option> , 表示开启option选项
 *  -XX:-<option> , 表示关闭option选项
 *
 *  （赋值）
 *  -XX:<option>=<value> , 表示将option选项的值设置为value
 *
 *  -Xms = -XX:InitialHeapSize
 *  -Xmx = -XX:MaxHeapSize
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        test2();
    }

    static void test1(){
        System.out.println(Child.parent);
    }

    static void test2(){
        System.out.println(Child.child);
    }
}

class Parent{
    public static String parent = "parent";

    static {
        System.out.println("parent static block");
    }
}

class Child extends Parent{
    public static String child = "child";

    static {
        System.out.println("Child static block");
    }
}