/**
 * @author hankin
 * @date 2020/6/28 11:29
 */

import java.util.Arrays;

/**
 * 归并排序：
 * 思想：先分，再合
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n)
 *
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        int length = arr.length;
        mergerSort(arr, 0, length - 1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
//        System.out.println(Arrays.toString(arr));
    }

    private static void mergerSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
//          分左
            mergerSort(arr, left, mid);
//          分右
            mergerSort(arr, mid + 1, right);
//          合
            merger(arr, left, mid, right);
        }
    }

    /**
     * temp 借助一个临时数组辅助我存储
     * point1 临时指针，指向左边第一个数
     * point2 临时指针，指向右边第一个数
     * loc 表示临时数组下标现在存的位置
     */
    private static void merger(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int point1 = left;
        int point2 = mid + 1;
        int loc = left;

        while (point1 <= mid && point2 <= right) {
            if (arr[point1] < arr[point2]) {
                temp[loc++] = arr[point1++];
//                point1++;
//                loc++;
            } else {
                temp[loc++] = arr[point2++];
//                point2++;
//                loc++;
            }
        }

        while (point1 <= mid) {
            temp[loc++] = arr[point1++];
        }
        while (point2 <= right) {
            temp[loc++] = arr[point2++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}
