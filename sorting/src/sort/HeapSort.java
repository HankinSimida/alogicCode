package sort;

import java.util.Arrays;

/**
 * @author hankin
 * @date 2020/7/25 15:58
 */
public class HeapSort {
    /**
     * 8 4 20 7 3 1 25 14 17
     * <p>
     *      1、建堆
     *       从后往前建堆
     * <p>
     *           8
     *          / \
     *         4   20
     *        /\   /\
     *      7  3 1 25
     *     / \
     *    14 17
     * <p>
     * 从 7 开始建堆因为 7有左右子节点方便比较
     *
     * 完全二叉树最后一个非叶子节点的位置 index = len/2 -1
     *
     * 应用：1、TOP K问题 1000w个数据找出前几个最大的
     *      2、定时任务，优先执行的任务变成小顶堆或大顶堆
     *
     *  1亿关键词，取出排行前10的关键词？
     *  1、统计频率---> Hash
     *  2、维护一个大小为10的大顶堆
     *
     *  若数据过大则放入到硬盘上
     *  一亿个数据分成10个文件 分别求top10 在最后求top10
     *
     */

    public static void main(String[] args) {
        int[] arr = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        heapSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    /**
     *  堆化时间复杂度 logn
     * @param data 数组
     * @param start
     * @param end 最多建到的点
     */
    private static void maxHeap(int[] data, int start, int end) {
        int parent = start;

        // 一般来说从下标为1开始的 left = 2*i， 下标为0时，left = 2*i+1
        int sonLeft = parent * 2 + 1;
        while (sonLeft < end) {
            int temp = sonLeft;
            // 比较左右节点与父节点的大小
            if (sonLeft + 1 < end && data[sonLeft] < data[sonLeft + 1]) {
                // 左 < 右 则 父与右交换 sonLeft + 1 表示右节点
                temp = sonLeft + 1;
            }
            if (data[parent] > data[temp]) {
                return;
            } else {
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;

                // 继续堆化
                parent = temp;
                sonLeft = parent * 2 + 1;
            }

        }
        return;
    }

    /**
     * 不稳定
     * 时间复杂度 n*logn
     * @param data
     */
    public static void heapSort(int[] data) {
        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeap(data, 0, i);
        }
    }
}
