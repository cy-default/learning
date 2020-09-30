package tmp;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/15
 */
public class SelectSortTest {

    public static void main(String[] args) {
        int[] arr = {-1,2,10,5,8, -10,2,4};

        for (int i=0; i<arr.length; i++){
            int index = i;
            int tmp = arr[i];
            for(int j=i; j<arr.length; j++){
                if(arr[j]<tmp){
                    index = j;
                    tmp = arr[j];
                }
            }
            arr[index] = arr[i];
            arr[i] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
