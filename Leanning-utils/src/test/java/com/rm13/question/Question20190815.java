package com.rm13.question;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-15
 *
 * 这里应该是most specific 原则，
 * 所有double[] 类型参数都可以是Object，
 * 但不是所有Object都是double[]。
 * 所以在这里Question20190815(double[] dArray) 更加 specific。
 */
public class Question20190815 {

    public static void main(String args[]) {
        new Question20190815(null);
    }

    public Question20190815(Object o) {
        System.out.println("Object");
    }
    public Question20190815(double[] dArray) {
        System.out.println("double array");
    }
}

