package net.leetcode.questions.two_pointers;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0042_trapping_rain_water3 {

    // 双指针（指针对撞）

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        // 注意初值的选取
        int left = 0;
        int right = len - 1;

        // 下面这种定义考虑了当前指针位置的高度，在后面计算的时候不用和当前高度作比较
        // 区间 [0, left] 的最大高度
        int curLeftHighest = height[0];
        // 区间 [right, len - 1] 的最大高度
        int curRightHighest = height[len - 1];

        int res = 0;
        // 当 left == right 的时候，[1, len - 2] 区间里的所有位置的下标都已经计算出来
        while (left < right) {
            curLeftHighest = Math.max(curLeftHighest, height[left]);
            curRightHighest = Math.max(curRightHighest, height[right]);

            if (curLeftHighest < curRightHighest) {
                res += curLeftHighest - height[left];
                left++;
            } else {
                res += curRightHighest - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        int res = solution4.trap(height);
        System.out.println(res);
    }
}
