package com.rm13.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/3
 */
public class MergeTest {

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 50};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int beg, int end){

        if(beg<end){
            int mid = (beg+end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, beg, mid, end);
        }
    }

    public static void merge(int[] arr, int beg, int mid, int end){

        int[] tmp = new int[arr.length];
        int p1=beg, p2=mid+1, index = beg;

        while(p1<=mid && p2<=end){
            if(arr[p1]<=arr[p2]){
                tmp[index] = arr[p1];
                p1++;
                index++;
            }else{
                tmp[index] = arr[p2];
                p2++;
                index++;
            }
        }

        while(p1<=mid){
            tmp[index] = arr[p1];
            p1++;
            index++;
        }

        while(p2<=end){
            tmp[index] = arr[p2];
            p2++;
            index++;
        }

        for(int i=beg; i<=end; i++){
            arr[i] = tmp[i];
        }
    }
}
