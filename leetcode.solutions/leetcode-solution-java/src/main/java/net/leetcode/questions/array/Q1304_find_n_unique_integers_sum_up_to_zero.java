package net.leetcode.questions.array;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1304_find_n_unique_integers_sum_up_to_zero {

    public int[] sumZero(int n) {
        int[] nums = new int[n];

        int half = n / 2;
        for (int i = 0; i < half; i++) {
            nums[i] = i + 1;
            nums[n - 1 - i] = -(i + 1);
        }

        return nums;
    }

    public static void main(String[] args) {
        Q1304_find_n_unique_integers_sum_up_to_zero solution = new Q1304_find_n_unique_integers_sum_up_to_zero();
        int n = 4;
        int[] res = solution.sumZero(n);
        System.out.println(Arrays.toString(res));
    }
}
