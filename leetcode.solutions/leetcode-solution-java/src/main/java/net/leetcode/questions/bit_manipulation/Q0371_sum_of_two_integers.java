package net.leetcode.questions.bit_manipulation;

public class Q0371_sum_of_two_integers {

    public int getSum(int a, int b) {
        int sum;
        while (true) {
            sum = a ^ b;
            int carry = a & b;
            if (carry == 0) {
                break;
            }
            a = sum;
            b = carry << 1;
        }
        return sum;
    }
}
