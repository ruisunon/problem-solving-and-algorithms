package net.leetcode.questions.dynamic_programming;

public class Q0123_best_time_to_buy_and_sell_stock_iii4 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // i 到第几天
        // j 第几次交易
        // k 是否持有股票

        // todo 解释清楚这里的 0 赋初值很重要

        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][0][0] = dp[i - 1][0][0];
        }
        return Math.max(Math.max(dp[len - 1][0][0], dp[len - 1][1][0]), dp[len - 1][2][0]);
    }

    public static void main(String[] args) {
        Q0123_best_time_to_buy_and_sell_stock_iii4 solution4 = new Q0123_best_time_to_buy_and_sell_stock_iii4();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int res = solution4.maxProfit(prices);
        System.out.println(res);
    }
}
