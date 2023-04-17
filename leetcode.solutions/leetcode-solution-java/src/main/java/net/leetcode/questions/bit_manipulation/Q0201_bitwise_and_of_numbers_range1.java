package net.leetcode.questions.bit_manipulation;

public class Q0201_bitwise_and_of_numbers_range1 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}