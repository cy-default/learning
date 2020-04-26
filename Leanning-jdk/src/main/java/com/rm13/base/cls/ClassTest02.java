package com.rm13.base.cls;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/1
 */
// 获取基本类型名称
public class ClassTest02 {
    public static void main(String[] args){
        System.out.println(int.class.getName());
        System.out.println(int.class.getSimpleName());
        System.out.println(int.class.getCanonicalName());
        System.out.println(int.class.getTypeName());
    }
}
