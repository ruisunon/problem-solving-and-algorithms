package net.leetcode.questions.hash_table;

public class Q0220_contains_duplicate_iii4 {

    // 超时

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[j] - nums[i]) <= t & Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
