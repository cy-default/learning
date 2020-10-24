package tmp;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/15
 */
public class Sort_QuickSortTest {

    public static void main(String[] args) {
        int[] arr = {-1,2,10,5,8, -10,2,4};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static int quick(int[] arr, int beg, int end){
        int tmp = arr[end];
        int index = beg;
        for(int i=beg; i<end; i++){
            if(arr[i]<tmp){
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index, end);
        return index;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void quickSort(int[] arr, int beg, int end){
        if(beg<end){
            int index = quick(arr, beg, end);
            quickSort(arr, beg, index-1);
            quickSort(arr, index+1, end);
        }


    }

}
