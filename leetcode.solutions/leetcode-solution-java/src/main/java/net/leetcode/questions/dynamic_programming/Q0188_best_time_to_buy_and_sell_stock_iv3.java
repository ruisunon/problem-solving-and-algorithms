package net.leetcode.questions.dynamic_programming;

public class Q0188_best_time_to_buy_and_sell_stock_iv3 {

    // 超时

    // 在差分数组上做最大 k 个连续子段和

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k < 1) {
            return 0;
        }

        if (k > len / 2) {
            k = len / 2;
        }

        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        // 最后一维：
        // 0：表示当前差分在上一个交易中
        // 1：表示当前差分是一个新的交易
        int[][][] dp = new int[len - 1][k + 1][2];
        dp[0][1][1] = diff[0];
        int res = Math.max(0, diff[0]);
        for (int i = 1; i < len - 1; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0]) + diff[i];
                res = Math.max(res, Math.max(dp[i][j][0], dp[i][j][1]));
            }
        }
        return res;
    }
}
