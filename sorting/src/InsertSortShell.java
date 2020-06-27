/**
 * @author hankin
 * @date 2020/6/27 21:42
 */

import java.util.Arrays;

/**
 * 希尔排序：由于插入排序的特性（数组尽可能的有序时，插入排序时间复杂度有明显的优化）
 * 思想：对数组通过增量分段得到一个稍微有序的数组，以此来提高插入排序的性能
 */
public class InsertSortShell {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        int n = arr.length;

        for (int add = n / 2; add >= 1; add /= 2) {
            for (int i = add; i < n; i++) {
                int data = arr[i];
                int j = i - add;
                for (; j >= 0; j -= add) {
                    if (arr[j] > data) {
                        arr[j + add] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + add] = data;
            }

        }

        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
