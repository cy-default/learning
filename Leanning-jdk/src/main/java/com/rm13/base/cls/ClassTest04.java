package com.rm13.base.cls;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/1
 */
// 获取数组类型名称
public class ClassTest04 {
    public static void main(String[] args){

        System.out.println(int[][].class.getName());
        System.out.println(int[][].class.getSimpleName());
        System.out.println(int[][].class.getCanonicalName());
        System.out.println(int[][].class.getTypeName());

        System.out.println();

        System.out.println(Integer[][].class.getName());
        System.out.println(Integer[][].class.getSimpleName());
        System.out.println(Integer[][].class.getCanonicalName());
        System.out.println(Integer[][].class.getTypeName());

    }
}
/*
[[I
int[][]
int[][]
int[][]

[[Ljava.lang.Integer;
Integer[][]
java.lang.Integer[][]
java.lang.Integer[][]
 */