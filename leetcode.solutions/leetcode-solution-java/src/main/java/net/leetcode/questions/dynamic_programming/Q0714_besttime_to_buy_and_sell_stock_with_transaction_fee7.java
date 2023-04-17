package net.leetcode.questions.dynamic_programming;

public class Q0714_besttime_to_buy_and_sell_stock_with_transaction_fee7 {

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // j = 0 表示不持股，j = 1 表示持股
        // 并且规定在买入股票的时候，扣除手续费
        int[] dp = new int[2];

        dp[0] = 0;
        dp[1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i] - fee);
        }
        return dp[0];
    }
}
