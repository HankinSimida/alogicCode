/**
 * @author hankin
 * @date 2020/6/27 13:29
 */

import java.util.Arrays;

/**
 * 插入排序
 * 思路：a.将数组分成已经拍好序段&未排好序段
 * b.未排序段取元素插入到已拍好序段，并保证插入后仍然有序
 * C.重复上述过程，直至未排序段元素全部加完
 * <p>
 * 联想：打扑克的场景
 * <p>
 * 时间：O(n^2)
 * 最佳时间复杂度：O(n) 已排序好的时候
 * 稳定性：稳定
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 0, 1, 3, 2};
        int n = arr.length;

//      第一层循环 未排序 个数
        for (int i = 1; i < n; i++) {  // 从1开始，因为第一个无序排序，0~i 认为已经排好序
            int data = arr[i];

//            第二层循环，将元素插入到已经排好序的段中
//            for(j = 0; j<i;j++){} 从头寻找（最后一个比自己小，第一个比自己大的位置）再插入,不太好 因为数组往后挪的时候从头操作不方便
            int j = i - 1;
            for (; j >= 0; j--) { //从尾到头寻找插入，便于数组往后挪动
                if (arr[j] > data) {
                    arr[j + 1] = arr[j];  //发现待插入数据小于末尾的数据，e.g: 已排好序[7,8,9] 待排序：0 ,故大于0的都要往后挪动一位
                } else {
                    break;   // 当发现待插入数据大于已经拍好序的数，则无需在比较之前的数，因为之前的数一定小于待插入数。故终止
                }
            }
            arr[j + 1] = data; //由于a[j + 1] = arr[j]，已经挪出空位且数组从第二个位置开始排序。所以直接最后赋值便可
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
