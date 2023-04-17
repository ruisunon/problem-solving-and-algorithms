package net.leetcode.questions.bit_manipulation;

public class Q0371_sum_of_two_integers1 {

    public int getSum(int a, int b) {
        int sum;
        int carry;
        do {
            sum = a ^ b;
            carry = a & b;

            a = sum;
            b = carry << 1;
        } while (carry != 0);
        return sum;
    }
}
