package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0122_best_time_to_buy_and_sell_stock_ii {

    // 贪心：只要有利润，就交易

    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Q0122_best_time_to_buy_and_sell_stock_ii solution = new Q0122_best_time_to_buy_and_sell_stock_ii();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
