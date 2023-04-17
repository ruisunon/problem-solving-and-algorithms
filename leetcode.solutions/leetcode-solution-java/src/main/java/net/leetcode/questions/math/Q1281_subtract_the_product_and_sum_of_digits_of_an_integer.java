package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q1281_subtract_the_product_and_sum_of_digits_of_an_integer {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {

            int num = n % 10;

            sum += num;
            product *= num;

            n /= 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        int n = 4421;
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.subtractProductAndSum(n);
        System.out.println(res);
    }
}
