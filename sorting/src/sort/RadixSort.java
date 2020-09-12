package sort;

import java.util.Arrays;

/**
 * 基数排序：经典的空间换时间
 *
 * @author hankin
 * @date 2020/9/12 11:17
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 541, 748, 14, 214};
        radixSort(arr);
    }


    private static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < 3; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int t = 0; t < bucketElementCounts[k]; t++) {
                        arr[index++] = bucket[k][t];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));


    }
}
