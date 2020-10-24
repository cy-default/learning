package tmp;

import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/15
 */
public class Sort_InsertSortTest {

    public static void main(String[] args) {
        int[] arr = {-1,2,10,5,8, -10,2,4};

        for (int i=1; i<arr.length; i++){
            int tmp = arr[i];
            int j = i-1;
            for (; j>=0; j--){
                if(tmp<arr[j]){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
