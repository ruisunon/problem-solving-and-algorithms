package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0053_maximum_subarray1 {

    /**
     * 和 Q0169_majority_element 一样，空间复杂度更小
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 起名叫 pre 表示的意思是“上一个状态”的值
        int pre = nums[0];
        int res = pre;
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}