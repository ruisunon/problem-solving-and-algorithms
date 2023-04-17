package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0518_coin_change22 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        int len = coins.length;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 500;
        int[] coins = {3, 5, 7, 8, 9, 10, 11};
        // 35502874
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int res = solution3.change(amount, coins);
        System.out.println(res);
    }
}
