package net.leetcode.questions.hash_table;

public class Q0001_two_sum {

    // 暴力解法

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
