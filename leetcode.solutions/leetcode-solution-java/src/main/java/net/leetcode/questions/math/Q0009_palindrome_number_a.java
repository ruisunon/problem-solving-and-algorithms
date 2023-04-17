package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0009_palindrome_number_a {

    public boolean isPalindrome(int x) {
        // 如果 x < 0 直接就可以判断不是回文数
        if (x < 0) {
            return false;
        }
        // 在执行得到反转的过程中，会改变 x 的值，所以用 x 的副本去完成这个逻辑
        return x == reverse(x);
    }

    private int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int x = 12321;
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);
    }
}
