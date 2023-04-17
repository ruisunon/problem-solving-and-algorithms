package net.leetcode.questions.bit_manipulation;

public class Q0201_bitwise_and_of_numbers_range2 {

    /**
     * 利用了 n &= (n - 1) 一下能消死一大片
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
        return n;
    }
}
