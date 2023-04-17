package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0633_sum_of_square_numbers {

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        if (c == 0 || c == 1) {
            return true;
        }
        int limit = (int) Math.sqrt(c);
        for (int i = 0; i <= limit; i++) {
            double another = Math.sqrt(c - i * i);
            if (another - (int) another == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int n = 2;
        boolean judgeSquareSum = solution2.judgeSquareSum(n);
        System.out.println(judgeSquareSum);
    }
}
