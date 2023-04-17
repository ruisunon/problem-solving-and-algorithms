package net.leetcode.questions.array;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q1295_find_numbers_with_even_number_of_digits {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = countDigit(num);
            if ((count & 1) == 0) {
                res += 1;
            }
        }
        return res;
    }

    private int countDigit(int num) {
        int count = 0;
        while (num > 0) {
            count += 1;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {555, 901, 482, 1771};
        Q1295_find_numbers_with_even_number_of_digits solution = new Q1295_find_numbers_with_even_number_of_digits();
        int res = solution.findNumbers(nums);
        System.out.println(res);
    }
}
