package net.leetcode.questions.two_pointers;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0011_container_with_most_water {

    // 暴力解法，时间复杂度太高，我们应该使用指针对撞的方法

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.maxArea(height);
        System.out.println(res);
    }
}
