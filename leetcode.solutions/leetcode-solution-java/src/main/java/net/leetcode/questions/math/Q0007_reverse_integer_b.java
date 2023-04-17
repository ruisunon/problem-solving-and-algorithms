package net.leetcode.questions.math;

public class Q0007_reverse_integer_b {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) res;
    }
}
