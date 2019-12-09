package com.rm13.classloader;
import java.util.UUID;


/**
 * 对于数组实例来说： 其类型是由JVM在运行期动态生成的， 表示为[Lcom.rm13.classloader.Parent5
 * 这种形式， 动态生成的类型，其父类型就是Object.
 *
 * 对于数组来说， javaDoc经常将构成数组的元素称为Componet， 实际上就是将数组降低一个维度后的类型
 *
 * 助记符：
 *  anewarray： a new array 表示创建一个引用类型的（如类， 接口， 数组）数组， 并将其引用值压入栈顶
 *  newarray： 表示创建一个指定的原始类型（如 int， float， char 等）的数组， 并将其引用值压入栈顶
 *
 */
public class ClassLoaderTest5 {

    public static void main(String[] args) {
        // new对象，属于主动使用， 会初始化
        // Parent5 parent5 = new Parent5();


        Parent5[] ps1 = new Parent5[1];
        // [Lcom.rm13.classloader.Parent5 这个类型
        // 数组类型， 虚拟机在运行的时候帮我们生成的，是一个数据类型。不是com.rm13.classloader.Parent5类型
        // 所以没有主动使用Parent5， 所以不会初始化。
        System.out.println(ps1.getClass());
        // class java.lang.Object
        System.out.println(ps1.getClass().getSuperclass());



        Parent5[][] ps2 = new Parent5[1][1];
        // [[Lcom.rm13.classloader.Parent5
        System.out.println(ps2.getClass());
        // class java.lang.Object
        System.out.println(ps2.getClass().getSuperclass());


        System.out.println("======");

        int[] its = new int[1];
        // [I
        System.out.println(its.getClass());
        // java.lang.Object
        System.out.println(its.getClass().getSuperclass());

        System.out.println("======");

        boolean[] bl = new boolean[1];
        bl[0] = true;
        // [I
        System.out.println(bl.getClass());
        // java.lang.Object
        System.out.println(bl.getClass().getSuperclass());


    }


}

class Parent5{

    static {
        System.out.println("parent static block");
    }
}


