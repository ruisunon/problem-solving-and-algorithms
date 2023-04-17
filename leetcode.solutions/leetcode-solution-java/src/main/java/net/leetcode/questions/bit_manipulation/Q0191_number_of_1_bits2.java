package net.leetcode.questions.bit_manipulation;

public class Q0191_number_of_1_bits2 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            n = n & 0x7fffffff;
            count++;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
