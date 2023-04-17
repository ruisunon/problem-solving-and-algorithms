package net.leetcode.questions.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liweiwei1419
 * @date 2019/11/2 10:09 上午
 */
public class Q0435_non_overlapping_intervals1 {

    // 贪心算法：区间按照结尾端点升序排序

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return 0;
        }

        // 区间按照结尾端点升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int res = 1;
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= end) {
                res += 1;
                end = intervals[i][1];
            }
        }
        return len - res;
    }
}