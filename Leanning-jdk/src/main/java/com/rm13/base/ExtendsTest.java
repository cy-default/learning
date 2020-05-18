package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/26
 */
public class ExtendsTest {
    public static void main(String[] args) {
        final Child child = new Child();

    }

    static class Parent {
        public Parent() {
            System.out.println("parent");
        }
    }

    static class Child extends Parent{

        public Child() {
            System.out.println("child");
        }
    }
}




