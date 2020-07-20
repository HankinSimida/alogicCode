/**
 * @author hankin
 * @date 2020/7/14 23:57
 */
public class DynamicPlan {

    /**
     *  --------------------------------------------
     * |        | 1KG  | 2kg  | 3KG  | 4KG  | 5KG  |
     * |--------------------------------------------
     * | 物品1  | ￥6  | ￥6  | ￥6   | ￥6  | ￥6  |
     * |-------------------------------------------
     * | 物品2  | ￥6  | ￥10 | ￥16 | ￥16 | ￥16 |
     * --------------------------------------------
     * | 物品3  | ￥6  | ￥10 | ￥16 | ￥16 | ￥18 |
     * -------------------------------------------
     *
     * 动态规划解决：相似度 编辑距离 两个字符串最长公共子串
     *
     * */

    public static void main(String[] args) {
        int[] value = {6, 10, 12};
        int[] weight = {1, 2, 4};

        // n表示物品 w表示重量 初始化全为0
        int w = 7;
        int n = 3;
        int[][] dp = new int[n + 1][w+1];

//        状态转移方程：每次和上面的比较 大就装入 否则就不装
//        Max(money[i]+dp[i-1][w-weight[i]],res[i-1][w])
//        money[i]+dp[i-1][w-weight[i]]:装这个物品  money[i]->当前物品的价值  dp[i-1][w-weight[i]]->上一次最大价值

        // 每次加的物品
        for (int i = 1; i <= n; i++) {

            // 分割的背包
            for (int cw = 1; cw <= w; cw++) {

                // 表示这个物品可以装进去
                if (weight[i - 1] <= cw) {
                    dp[i][cw] = Math.max(value[i - 1] + dp[i - 1][cw - weight[i - 1]],
                            dp[i - 1][cw]);
                } else {
                    // 不能装
                    dp[i][cw] = dp[i - 1][cw];
                }
            }
        }

        System.out.println("最大价值为：" + dp[n][w]+"￥");

        // 输出矩阵
        for (int i = 1; i <= n; i++) {
            for (int cw = 1; cw <= w; cw++) {
                System.out.print("￥"+dp[i][cw] + " ");
            }
            System.out.println();
        }

        System.out.println("具体物品");
        for (int i = n; i > 1; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println(i + " : " + weight[i - 1]);
                w = w - weight[i - 1];
            }
        }
        if (w != 0) {
//            表示最后一个物品要加进来
            System.out.println(1 + " : " + weight[0]);
        }
    }
}
