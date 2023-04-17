package net.leetcode.questions.bit_manipulation;

public class Q0191_number_of_1_bits1 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
