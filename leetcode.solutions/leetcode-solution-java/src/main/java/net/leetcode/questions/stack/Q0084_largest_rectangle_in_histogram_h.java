package net.leetcode.questions.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import net.leetcode.questions.two_pointers.Q0042_trapping_rain_water7;

public class Q0084_largest_rectangle_in_histogram_h {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];

                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth = i - stack.peekLast() - 1;

                res = Math.max(res, curHeight * curWidth);
            }
            stack.add(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Q0084_largest_rectangle_in_histogram_h solution6 = new Q0084_largest_rectangle_in_histogram_h();
        int res = solution6.largestRectangleArea(heights);
        System.out.println(res);
    }
}
