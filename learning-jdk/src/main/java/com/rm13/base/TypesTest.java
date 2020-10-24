package com.rm13.base;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/9
 */
@Data
public class TypesTest<T> {

    T param;

    public static void main(String[] args) {
        TypesTest<String> test = new TypesTest<>();
        test.setParam("string");
        final List<String> strings = Arrays.asList("1", "2");
        test(strings);

    }
    public void test1(List<Object> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public void test2(List<String> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public static void test(List<?> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
