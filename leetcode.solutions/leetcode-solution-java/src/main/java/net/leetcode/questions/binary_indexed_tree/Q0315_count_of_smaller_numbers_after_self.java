package net.leetcode.questions.binary_indexed_tree;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0315_count_of_smaller_numbers_after_self {

    // 暴力解法（超时）

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        if (len == 0) {
            return res;
        }

        for (int i = 0; i < len - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> res = solution.countSmaller(nums);
        System.out.println(res);
    }
}
