package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0136_single_number {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        Q0027_remove_element solution = new Q0027_remove_element();
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
    }
}
