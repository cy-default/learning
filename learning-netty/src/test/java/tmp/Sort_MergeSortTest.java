package tmp;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/15
 */
public class Sort_MergeSortTest {

    public static void main(String[] args) {
        int[] arr = {-1, 2, 10, 5, 8, -10, 2, 4};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));


    }

    public static void mergeSort(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

    private static void merge(int[] arr, int beg, int mid, int end) {
        int[] tmp = new int[arr.length];

        int p1 = beg, p2 = mid + 1, index = beg;

        while (p1 <= mid && p2 <= end) {
            if (arr[p1] < arr[p2]) {
                tmp[index++] = arr[p1++];
            } else {
                tmp[index++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            tmp[index++] = arr[p1++];
        }

        while (p2 <= end) {
            tmp[index++] = arr[p2++];
        }

        for(int i=beg; i<=end; i++){
            arr[i] = tmp[i];
        }
    }


}
