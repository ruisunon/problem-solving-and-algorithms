package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0507_perfect_number {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        // 所有乘法因子的和存在这里
        int res = 1;
        // 可能的乘法因子，从 2 开始
        int factor = 2;
        while (factor * factor < num) {
            if (num % factor == 0 ) {
                res += factor;
                res += (num / factor);
            }
            factor += 1;
        }
        // 把中间那个数单独拿出来
        if (factor * factor == num) {
            res += factor;
        }
        return res == num;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        int num = 28;
        boolean res = solution.checkPerfectNumber(num);
        System.out.println(res);
    }
}
