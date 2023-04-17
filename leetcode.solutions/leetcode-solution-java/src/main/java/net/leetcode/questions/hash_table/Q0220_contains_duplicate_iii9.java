package net.leetcode.questions.hash_table;

import java.util.TreeSet;

public class Q0220_contains_duplicate_iii9 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        // 特判
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);

            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }

            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
