package net.leetcode.questions.dynamic_programming;

public class Q0121_best_time_to_buy_and_sell_stock2 {

    // 动态规划

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i] ：区间 [0, i] 天里，下标 i 这一天状态为 i 的最大利润

        // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，不是指没有进行过任何交易的不持股
        // 1：用户手上持股所能获得的最大利润
        
        // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        // 状态转移方程：
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = max(dp[i - 1][1], -prices[i])
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
