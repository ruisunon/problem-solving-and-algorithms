package net.leetcode.questions.stack;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0084_largest_rectangle_in_histogram {

    // 暴力解法

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;

            // 找左边第 1 个严格小于 heights[i] 的索引
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            // 找右边第 1 个严格小于 heights[i] 的索引
            while (right < len - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }

            // System.out.println("左：" + left + "，右："+ right + "，高："+ heights[i]);
            int width = right - left + 1;
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Q0084_largest_rectangle_in_histogram solution = new Q0084_largest_rectangle_in_histogram();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}
