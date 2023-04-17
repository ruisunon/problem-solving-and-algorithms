package net.leetcode.questions.bit_manipulation;

public class Q0338_counting_bits1 {

    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ret[i] = bitCount(i);
        }
        return ret;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
