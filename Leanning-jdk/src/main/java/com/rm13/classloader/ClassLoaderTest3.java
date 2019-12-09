package com.rm13.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在类的常量池中，
 * 本质上， 调用类并没有直接引用到定义常量的类，
 * 因此， 并不会触发定义常量的类的初始化
 *
 * 注意： 这里指的是将常量存放到了ClassLoaderTest3的常量池中。
 * 之后ClassLoaderTest3与Parent3就没有任何关系了。
 * 甚至： 我们可以将Parent3的class文件删除
 */
public class ClassLoaderTest3 {

    public static void main(String[] args) {
        System.out.println(Parent3.parent);
        System.out.println(Parent3.aa);
        System.out.println(Parent3.bb);
        System.out.println(Parent3.cc);
        System.out.println(Parent3.dd);
        System.out.println(Parent3.ee);
        System.out.println(Parent3.ff);
        System.out.println(Parent3.gg);

    }


}

class Parent3{
    public static final String parent = "parent3";

    public static final byte aa = 7;

    public static final int bb = 128;

    public static final int cc = 1;

    public static final int dd = 6;

    public static final long ee = 10L;

    public static final boolean ff = true;

    public static final boolean gg = false;

    static {
        System.out.println("parent static block");
    }
}


/*

反编译
javap -c ClassLoaderTest3.class



助记符：
    ldc：表示将int，float, 或是String类型的常量值从常量池中推送至栈顶
    ldc2_w:
    bipush: 表示将单字节（-128 - 127）的常量值推送至栈顶
    sipush: 表示将一个短整型常量值（-32768 - 32767）的常量值推送至栈顶
    iconst_1: 表示将int类型的1推送至栈顶（iconst_m1 - iconst_5 (-1到5)）


    在Java虚拟机中没有任何供 boolean值专用的字节码指令， Java语言表达式所操作的boolean值,在编译之后都使用Java虚拟机中的int数据类型来代替。
    iconst_0 表示false， iconst_1表示true

    Java虚拟机直接支持 boolean类型的数组,虚拟机的 navarra指令参见第6章的newarray小节可以创建这种数组。boolean类型数组的访问与修改共用byte类型数组的baload和 bastore指令。


Compiled from "ClassLoaderTest3.java"
public class com.rm13.classloader.ClassLoaderTest3 {
  public com.rm13.classloader.ClassLoaderTest3();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

   public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #4                  // String parent3
       5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      11: bipush        7
      13: invokevirtual #6                  // Method java/io/PrintStream.println:(I)V
      16: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      19: sipush        128
      22: invokevirtual #6                  // Method java/io/PrintStream.println:(I)V
      25: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      28: iconst_1
      29: invokevirtual #6                  // Method java/io/PrintStream.println:(I)V
      32: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      35: bipush        6
      37: invokevirtual #6                  // Method java/io/PrintStream.println:(I)V
      40: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      43: ldc2_w        #7                  // long 10l
      46: invokevirtual #9                  // Method java/io/PrintStream.println:(J)V
      49: return

}



 */