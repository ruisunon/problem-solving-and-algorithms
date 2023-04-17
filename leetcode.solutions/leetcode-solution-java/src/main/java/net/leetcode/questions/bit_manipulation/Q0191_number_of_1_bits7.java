package net.leetcode.questions.bit_manipulation;

public class Q0191_number_of_1_bits7 {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
