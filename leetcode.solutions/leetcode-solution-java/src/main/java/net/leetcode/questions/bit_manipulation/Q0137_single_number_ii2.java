package net.leetcode.questions.bit_manipulation;

public class Q0137_single_number_ii2 {

    public int singleNumber(int[] nums) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                res |= mask;
            }
            mask <<= 1;
        }
        return res;
    }
}
