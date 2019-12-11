package com.rm13.base.cls;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-09
 */
public class ClassTest {

    public static void main(String[] args) {
        for (Class<?> c : C.class.getInterfaces()) {
            System.out.println(c.getName());
        }
    }
}


interface A{
    void a();
}

interface B extends A{
    void b();
}

interface C extends B{
    void c();
}