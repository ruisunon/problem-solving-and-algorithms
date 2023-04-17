package net.leetcode.questions.math;

public class Q0263_ugly_number1 {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0) {
                num /= factor;
            }
        }
        return num == 1;
    }
}