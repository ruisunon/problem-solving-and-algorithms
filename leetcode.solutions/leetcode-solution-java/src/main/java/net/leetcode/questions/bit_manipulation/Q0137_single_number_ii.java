package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0137_single_number_ii {

    public int singleNumber(int[] nums) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((mask & num) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res |= mask;
            }
            mask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5};
        // int[] nums = {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
    }
}
