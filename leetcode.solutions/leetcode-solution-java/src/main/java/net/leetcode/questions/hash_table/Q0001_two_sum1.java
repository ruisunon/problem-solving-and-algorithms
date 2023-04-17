package net.leetcode.questions.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Q0001_two_sum1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int another = target - nums[i];
            if (hashMap.containsKey(another)) {
                return new int[]{i, hashMap.get(another)};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
