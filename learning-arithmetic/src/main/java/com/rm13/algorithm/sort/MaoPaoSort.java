package com.rm13.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/26
 */
public class MaoPaoSort {

    public static void main(String[] args) {
        test0();
        test1();
    }

    public static void test0(){
        System.out.println("test0");
        int[] arr = {-1,2,10,5,8, -10,2,4};

        // 外层是循环轮次
        for (int i=0; i< arr.length-1; i++){
            // 内层是元素比较
            for (int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }

    public static void test1(){
        System.out.println("test1");
        int[] arr = {-1,2,10,5,8, -10,2,4};

        for (int i=0; i<arr.length; i++){
            boolean flag = true;
            for(int j=1; j<arr.length-i; j++){
                if(arr[j-1]>arr[j]){
                    flag = false;
                    int tm = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tm;
                }
            }
            if(flag){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
