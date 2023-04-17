package net.leetcode.questions.bit_manipulation;

public class Q0191_number_of_1_bits3 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
