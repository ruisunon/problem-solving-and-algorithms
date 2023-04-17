package net.leetcode.questions.hash_table;

import java.util.Arrays;

/**
 * 排序，逐个检查
 */
public class Q0217_contains_duplicate1 {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        // 特判
        if (len < 2) {
            return false;
        }

        // 原地排序，这一步是关键
        Arrays.sort(nums);

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
