package net.leetcode.questions.dynamic_programming;

public class Q0121_best_time_to_buy_and_sell_stock4 {

    // 动态规划：滚动数组

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][1] + prices[i]);
            dp[i & 1][1] = Math.max(dp[(i - 1) & 1][1], -prices[i]);
        }
        return dp[(len - 1) & 1][0];
    }
}
