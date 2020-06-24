/**
 * @author hankin
 * @date 2020/6/24 11:21
 */

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 题源：1
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        twoSum(nums, 6);
    }

    public static int[] twoSum(int[] nums, int target) {
        /**
         * 该解法为常规方法 两层嵌套循环遍历
         * O(n2)
         *
         **/
        /*int[] findIndexArr =new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    findIndexArr[0] = i;
                    findIndexArr[1] = j;
                    break;
                }
            }
        }
        return findIndexArr;*/

        /**
         * O(n)解法
         * Key 为补数，value为补数的下标
         * 思想：依次将存入补数，再往后寻找补数
         * */
        int[] indexs = new int[2];

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[1] = i;
                indexs[0] = hash.get(nums[i]);
            }
            hash.put(target - nums[i], i);
        }
        return indexs;
    }
}