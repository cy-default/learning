package tmp;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/15
 */
public class Sort_MaopaoTest {

    public static void main(String[] args) {
        int[] arr = {-1,2,10,5,8, -10,2,4};

        for (int i=0; i<arr.length; i++){
            boolean flag = false;
            for(int j=1; j<arr.length-i; j++){

                if(arr[j-1]>arr[j]){
                    flag = true;
                    swap(arr, j-1, j);
                }
            }

            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
