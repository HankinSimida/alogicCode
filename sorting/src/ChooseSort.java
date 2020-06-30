/**
 * @author hankin
 * @date 2020/6/29 12:45
 */

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 不稳地
 */
/**
 * minLoc:记住最小下标值
 * 找到最小的数，记住下标然后每一次内层循环结束后判断
 * i是否与minLoc相等 等则不交换，不等就交换
 *
 * i->控制大循环次数，一般是数组长度-1
 * j->内循环寻找最小数
 *
 * */
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 0, 7, 1, 3, 2};
        int n = arr.length;
        for (int i = 0; i < n-1 ; i++) {
            int minLoc = i;
            for (int j = i +1 ; j < n; j++) {
                if (arr[j] < arr[minLoc]) {
                    minLoc = j;
                }
            }
            if (i != minLoc) {
                int temp = arr[minLoc];
                arr[minLoc] = arr[i];
                arr[i] = temp;
            }

        }
        System.out.println(Arrays.toString(arr));

    }


}
