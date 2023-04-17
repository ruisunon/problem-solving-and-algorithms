package net.leetcode.questions.bit_manipulation;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0442_find_all_duplicates_in_an_array {

    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        // 特判
        if (len == 0) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            // 1 应该在索引 0 上，2 应该在索引 1 上
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 调试代码
        // System.out.println(Arrays.toString(nums));

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }


    private void swap(int[] nums, int index1, int index2) {
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> res = solution.findDuplicates(nums);
        System.out.println(res);
    }

}

