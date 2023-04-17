package net.leetcode.questions.dynamic_programming;

public class Q0122_best_time_to_buy_and_sell_stock_ii1 {

    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            res += Math.max(prices[i + 1] - prices[i], 0);
        }
        return res;
    }
}
