package net.leetcode.questions.dynamic_programming;

public class Q0714_besttime_to_buy_and_sell_stock_with_transaction_fee4 {

    // 贪心算法

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int curMinVal = prices[0];
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            if (prices[i + 1] >= prices[i]) {
                continue;
            } else {
                res += Math.max(0, prices[i] - curMinVal - fee);
                curMinVal = prices[i + 1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Q0399_evaluate_division5 solution5 = new Q0399_evaluate_division5();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9,-1};
        int fee = 2;
        int res = solution5.maxProfit(prices, fee);
        System.out.println(res);
    }
}
