package sort;

import java.util.Arrays;

/**
 * @author hankin
 * @date 2020/9/5 11:08
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
//        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int n = arr.length;
        bubble(arr, n);
        System.out.println(Arrays.toString(arr));

    }

    private static void bubble(int[] arr, int n) {
        boolean flag =false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag =true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

}
