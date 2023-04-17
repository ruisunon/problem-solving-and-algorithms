package net.leetcode.questions.dynamic_programming;

public class Q0053_maximum_subarray5 {

    // 状态压缩

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
