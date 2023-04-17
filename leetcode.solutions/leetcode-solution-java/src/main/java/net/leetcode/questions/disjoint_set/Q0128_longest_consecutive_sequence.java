package net.leetcode.questions.disjoint_set;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0128_longest_consecutive_sequence {

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(nums);

        int longestLen = 1;
        int res = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == (pre + 1)) {
                longestLen++;
                res = Math.max(res, longestLen);
            } else {
                longestLen = 1;
            }
            pre = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence solution = new Q0128_longest_consecutive_sequence();
        // int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums = new int[]{1, 2, 0, 1};
        int res = solution.longestConsecutive(nums);
        System.out.println(res);
    }
}
