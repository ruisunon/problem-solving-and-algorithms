package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0983_minimum_cost_for_tickets {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len - 1];

        // 数组的作用是代替哈希表，以便后续快速检测是否当天有旅行
        int[] hashMap = new int[366];
        for (int day : days) {
            hashMap[day]++;
        }

        // dp[i]：到下标为 i 的这一天，旅行所需要的最低消费
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (hashMap[i] == 1) {
                dp[i] = min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {7, 2, 15};
//        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
//        int[] costs = {2, 7, 15};
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.mincostTickets(days, costs);
        System.out.println(res);
    }
}
