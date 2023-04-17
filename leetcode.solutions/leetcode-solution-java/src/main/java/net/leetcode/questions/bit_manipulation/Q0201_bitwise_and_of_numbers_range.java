package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0201_bitwise_and_of_numbers_range {

    /**
     * 暴力解法会超时
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int m = 200;
        int n = 230;
        int rangeBitwiseAnd = solution.rangeBitwiseAnd(m, n);

        for (int i = m; i <=n ; i++) {
            System.out.printf("%-3d %32s",i,Integer.toBinaryString(i));
            System.out.println();
        }

        System.out.println("结果：");
        System.out.printf("%-3d %32s",rangeBitwiseAnd,Integer.toBinaryString(rangeBitwiseAnd));
    }
}
