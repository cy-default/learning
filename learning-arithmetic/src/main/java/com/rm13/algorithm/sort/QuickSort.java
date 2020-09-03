package com.rm13.algorithm.sort;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/3
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        quickSortC(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortC(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int q = partition(a, start, end);
        quickSortC(a, start, q - 1);
        quickSortC(a, q + 1, end);
    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        // 通过下标 i 把数组分成两部分；i-1下标之前的叫做：已处理区间； i下标之后的叫做：未处理区间
        // 每次从未处理区间中取一个元素与pivot比较。如果小于pivot；则将其加入到已处理区间的尾部。
        // 遍历 start 到 end 区间的数组数据
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i = i + 1;
            }
        }
        swap(a, i, end);
        return i;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
