package net.leetcode.questions.bit_manipulation;

/**
 * @author liwei
 * @date 18/6/30 下午9:50
 */
public class Q0231_power_of_two1 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
