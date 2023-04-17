package net.leetcode.questions.dynamic_programming;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

// 找规律的解法
public class Q0343_integer_break2 {

    public int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence3 s = new Q0128_longest_consecutive_sequence3();
        int maxBreak = s.integerBreak(4);
        System.out.println(maxBreak);
    }
}
