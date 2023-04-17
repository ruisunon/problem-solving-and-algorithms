package net.leetcode.questions.math;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1317_convert_integer_to_the_sum_of_two_no_zero_integers {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n - 1; i++) {
            if (containsZero(i) && containsZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }

    private boolean containsZero(int num) {
        String numStr = num + "";
        return !numStr.contains("0");
    }

    public static void main(String[] args) {
        int n = 1010;
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] res = solution.getNoZeroIntegers(n);
        System.out.println(Arrays.toString(res));
    }
}
