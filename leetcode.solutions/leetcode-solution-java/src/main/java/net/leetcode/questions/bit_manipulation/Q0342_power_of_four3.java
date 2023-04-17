package net.leetcode.questions.bit_manipulation;

/**
 * @author liwei
 * @date 18/6/30 下午7:33
 */
public class Q0342_power_of_four3 {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}
