package net.leetcode.questions.hash_table;

public class Q0220_contains_duplicate_iii6 {

    // 超时

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        long a;
        long b;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len && j <= i + k; j++) {
                a = nums[i];
                b = nums[j];
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
