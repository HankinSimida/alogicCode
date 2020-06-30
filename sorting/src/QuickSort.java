/**
 * @author hankin
 * @date 2020/6/30 14:45
 */

import java.util.Arrays;

/**
 * 快速排序
 * 基准数的选取决定快速排序的执行的效率（一般而言去第一个）
 * <p>
 * 操作过程：
 * 从后往前找，找到比基准数小的数并和他交换
 * 再从前往后找，找到比基准数大的数并和他交换
 * 反复几次后
 * 数据将分成三块 {小于基准数的} 基准数 {大于基准数}
 * 然后左右分别递归
 * <p>
 * 时间复杂度o(n^2)
 * 空间复杂度o(1)
 * 不稳定
 */
public class QuickSort {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) {
        int[] arr = {100, 201, 89, 45, 32, 120, 89, 66, 101};
        qSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(a);
        System.out.println(b);
    }

    public static void qSort(int[] data, int left, int right) {

        int base = data[left];
        int ll = left;
        int rr = right;

        while (ll < rr) {
//          从后往前找,没找到,rr--往前找
            while (ll < rr && data[rr] >= base) {
                rr--;
            }
//           找到后,交换位置,ll往前+1
            if (ll < rr) {
                a++;
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;
            }
//           现在从前往后找，没找到,ll++往后找
            while (ll < rr && data[ll] <= base) {
                ll++;
            }
//           找到后,交换位置,rr往后-1
            if (ll < rr) {
                b++;
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                rr--;
            }
//            开始递归 分成三部 左右分别快排
            if (left < ll) {

                qSort(data, left, ll - 1);
            }
            if (ll < right) {

                qSort(data, ll + 1, right);
            }
        }
    }
}
