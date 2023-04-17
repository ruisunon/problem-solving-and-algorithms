package net.leetcode.questions.bit_manipulation;

public class Q0191_number_of_1_bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        char[] binaryArr = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (char b : binaryArr) {
            if (b == '1') {
                count++;
            }
        }
        return count;
    }
}
