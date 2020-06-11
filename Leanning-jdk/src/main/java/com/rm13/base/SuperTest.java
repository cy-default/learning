package com.rm13.base;

/**
 * 子类构造方法
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/11
 */
public class SuperTest {

    public static void main(String[] args) {
        final Child child = new Child();
    }
}

class Parent{
    public Parent(){
        System.out.println("parent");
    }
}

class Child extends Parent{
    public Child(){
        System.out.println("child");
    }
}
