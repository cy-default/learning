package com.rm13.base;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/5/11
 */
public class VoliatieTest {

    public static void main(String[] args) {
        final Person ali = new Person("ali");
        System.out.println(ali);
    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
