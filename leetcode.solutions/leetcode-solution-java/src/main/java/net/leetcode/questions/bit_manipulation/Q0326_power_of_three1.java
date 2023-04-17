package net.leetcode.questions.bit_manipulation;

public class Q0326_power_of_three1 {

    /**
     * 因为 3 是质数，用 3 的方幂的最大值去整除这个待检测的数即可
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
