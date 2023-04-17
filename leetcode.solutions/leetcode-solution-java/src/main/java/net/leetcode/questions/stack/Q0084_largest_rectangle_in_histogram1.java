package net.leetcode.questions.stack;

import java.util.Stack;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0084_largest_rectangle_in_histogram1 {

    // 不使用哨兵的写法

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                // top 所在的柱形的最大高度可以确定
                int top = stack.pop();
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                res = Math.max(res, heights[top] * width);
            }
            stack.push(i);
        }

        // 注意：如果栈里有元素，需要清空
        while (!stack.isEmpty()) {
            // top 所在的柱形的最大高度可以确定
            int top = stack.pop();
            int width;

            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peek() - 1;
            }

            res = Math.max(res, heights[top] * width);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Q0084_largest_rectangle_in_histogram1 solution2 = new Q0084_largest_rectangle_in_histogram1();
        int res = solution2.largestRectangleArea(heights);
        System.out.println(res);
    }
}
