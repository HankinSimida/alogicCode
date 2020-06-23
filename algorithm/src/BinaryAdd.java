/**
 * @author hankin
 * @date 2020/6/23 13:26
 */
public class BinaryAdd {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0
     * 题源:67
     */


    /***
     * 思路 ：[1,0,1] [1,1,1]
     *             \ /
     *           [2,1,2]  -->申请辅助数组时候 要在最大的数组上+1 以备首尾是2的情况
     *         遇到二：递归：逢二进一（从头部开始）
     *          0和1 保留原值
     *         第一次：[1,0,1,2]
     *         第二次：[1,0,2,0]
     *         第三次：[1,1,1,0]
     * */
    public static void main(String[] args) {
        addBinary("100", "110010");

    }

    public static String addBinary(String a, String b) {
//        强制 a的长度大于b的长度 不满足则a b交换
        if (a.length() < b.length()) {
            String c = b;
            b = a;
            a = c;
        }
//      申请辅助数组 最大数组长度+1
        int[] all = new int[a.length() + 1];

//        从末尾遍历然后相加
        for (int i = a.length() - 1, j = b.length() - 1; j >= 0; i--, j--) {
            int i1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int i2 = Integer.parseInt(String.valueOf(b.charAt(j)));
            all[i + 1] = i1 + i2;
        }

//      长度大的数组高位补齐
        for (int i = 1; i <= a.length() - b.length(); i++) {
            all[i] = Integer.parseInt(String.valueOf(a.charAt(i - 1)));
        }

//        得到相加后的数组，进入逢二进一操作
        int[] ints = reCompute(all);

//        还原成字符串
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            if (i == 0 && ints[i] == 0) {
                continue;
            }
            s.append(ints[i]);
        }
        return s.toString();

    }


    public static int[] reCompute(int[] all) {
//        原则 逢二进一，然后置0 ，原味为0,1保留原值
        for (int i = 1; i <= all.length - 1; i++) {
            if (all[i] == 2) {
                all[i] = 0;
                all[i - 1] = all[i - 1] + 1;
                reCompute(all);
            } else {
                all[i] = all[i];
            }
        }

        return all;
    }
}
