package net.leetcode.questions.bit_manipulation;

/**
 * @author liwei
 * @date 18/6/30 下午9:52
 */
public class Q0231_power_of_two2 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.toString(n, 2).matches("^10*$");
    }
}
