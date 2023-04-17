package net.leetcode.questions.bit_manipulation;

/**
 * 练习
 *
 * @author liwei
 * @date 18/7/1 下午5:49
 */
public class Q0371_sum_of_two_integers2 {

    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        while (true) {
            sum = a ^ b;
            // 括号不能丢
            carry = (a & b) << 1;
            if (carry == 0) {
                break;
            }
            a = sum;
            b = carry;
        }
        return sum;
    }
}
