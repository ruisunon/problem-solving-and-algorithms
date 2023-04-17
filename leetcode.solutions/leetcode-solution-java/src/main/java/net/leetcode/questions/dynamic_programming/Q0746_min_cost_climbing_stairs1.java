package net.leetcode.questions.dynamic_programming;

public class Q0746_min_cost_climbing_stairs1 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[len];
    }
}
