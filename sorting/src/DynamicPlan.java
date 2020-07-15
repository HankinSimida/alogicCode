/**
 * @author hankin
 * @date 2020/7/14 23:57
 */
public class DynamicPlan {
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 40};

        // n表示物品 w表示重量 初始化全为0
        int w = 50;
        int n = 3;
        int[][] dp = new int[n + 1][w + 1];

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
        System.out.println(dp[n][w]);
    }
}
