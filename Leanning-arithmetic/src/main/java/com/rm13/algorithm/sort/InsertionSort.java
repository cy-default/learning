package com.rm13.algorithm.sort;

/**
 * 插入排序
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-10-23
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] num = new int[]{5,4,3,2,1};
        sort(num, num.length);
        System.out.println(InsertionSort.class.getResource("").getPath());

    }

    public static void sort(int[] arr, int num){

        for (int i = 1; i < num; i++) {
            int val = arr[i];
            int j = i-1;
            for (; j>=0 ; j--) {

                if(arr[j]>val){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = val;
        }

        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.println();

    }
}
