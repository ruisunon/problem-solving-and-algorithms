package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0367_valid_perfect_square {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int left = 1;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num % mid == 0 && num / mid == mid) {
                return true;
            } else if (num / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean res = solution.isPerfectSquare(5);
        System.out.println(res);
    }
}
