package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0231_power_of_two {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean powerOfTwo = solution.isPowerOfTwo(4);
        System.out.println(powerOfTwo);
    }
}
