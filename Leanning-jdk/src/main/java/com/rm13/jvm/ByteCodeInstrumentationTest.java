package com.rm13.jvm;

/**
 * 字节码指令测试
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/15
 */
public class ByteCodeInstrumentationTest {

    static {
        System.out.println("static ByteCodeInstrumentationTest");
    }

    public static void booleanArrayTest(){
        boolean[] arg = {true, false};
    }

    public static void bolleanTest(){
        boolean flag = true;
    }

    /**
     * dup 解析
     */
    public static void dupTest(){

        ByteCodeInstrumentationTest byteCodeInstrumentationTest = new ByteCodeInstrumentationTest();
    }

    /**
     * 非静态方法（包括普通方法/构造方法）第一个参数是this对象
     * 静态方法第一个参数表示对方法第一个参数的操作
     */
    public void args(String a, String b){
        System.out.println("args");
    }
}
