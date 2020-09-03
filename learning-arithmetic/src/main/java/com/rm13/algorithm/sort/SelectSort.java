package com.rm13.algorithm.sort;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/1
 */
public class SelectSort {


    public static void main(String[] args) {
        select();
    }

    public static void select(){
        int[] arr = {3,5,8,4,1,6,9};

        for(int i=0; i<arr.length; i++){
            int tmp = arr[i];
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<tmp){
                    tmp = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex]=arr[i];
            arr[i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
