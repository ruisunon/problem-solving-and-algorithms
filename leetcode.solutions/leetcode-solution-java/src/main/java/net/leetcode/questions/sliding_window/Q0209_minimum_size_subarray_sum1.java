package net.leetcode.questions.sliding_window;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0209_minimum_size_subarray_sum1 {

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 由于 nums 全都是正整数，因此 preSum 严格单调增加
        // preSum 表示 sum(nums[0..i))
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int minLen = len + 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (preSum[j + 1] - preSum[i] >= s) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        if (minLen == len + 1) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int minSubArrayLen = solution2.minSubArrayLen(s, nums);
        System.out.println(minSubArrayLen);
    }
}
