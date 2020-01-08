package com.rm13.classloader;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/6
 */
public class ClassLoaderTest001 {

    public static void main(String[] args) {
        ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        System.out.println(ccl.getClass().getName());
        System.out.println(ccl.getClass().getSuperclass().getName());
        System.out.println(ccl.getClass().getSuperclass().getSuperclass().getName());

        System.out.println(ClassLoaderTest001.class.getClassLoader().getClass().getName());
    }
}
