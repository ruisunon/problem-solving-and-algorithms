package net.leetcode.questions.lcci;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q_1716_the_masseuse_lcci3 {

    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i][0]：区间 [0，i] 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0，i] 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i & 1][0] = Math.max(dp[(i - 1) & 1][0], dp[(i - 1) & 1][1]);
            dp[i & 1][1] = dp[(i - 1) & 1][0] + nums[i];
        }
        return Math.max(dp[(len - 1) & 1][0], dp[(len - 1) & 1][1]);
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence4 solution = new Q0128_longest_consecutive_sequence4();
        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int res = solution.massage(nums);
        System.out.println(res);
    }
}
