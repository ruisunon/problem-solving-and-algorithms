package net.leetcode.questions.hash_table;

import java.util.HashMap;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0219_contains_duplicate_ii {

    // 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
    // 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
    // "并且 i 和 j 的差的绝对值最大为 k"，改成"并且 i 和 j 的差的绝对值不超过 k" 或许就好理解多了

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        // 特判
        if (len < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    // 只要找到 1 个符合题意的就返回
                    return true;
                }
            }
            // 更新为最新的索引，这里有贪心选择的思想，索引越靠后，符合题意的数据对的存在性就越大
            map.put(nums[i], i);
        }
        // 遍历完成以后，都没有符合题意的时候，才返回 False
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        // int[] nums = {1, 0, 1, 1};
        // int k = 1;
        // int[] nums = {1, 2, 3, 1, 2, 3};
        // int k = 2;
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean containsNearbyDuplicate = solution.containsNearbyDuplicate(nums, k);
        System.out.println(containsNearbyDuplicate);
    }
}
