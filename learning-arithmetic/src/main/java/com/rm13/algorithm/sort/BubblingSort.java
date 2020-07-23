package com.rm13.algorithm.sort;

/**
 * 冒泡排序
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-10-23
 */

public class BubblingSort {


    public static void main(String[] args) {
        int[] num = new int[]{3,2,1,6,5,4};
        sort(num, num.length);
    }

    public static void sort(int[] arr, int n){

        int tmp;
        boolean sorted = false;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    sorted = true;
                }
            }

            if(!sorted){
                break;
            }
        }

        for (int i : arr) {
            System.out.print(i+", ");
        }
    }
}
