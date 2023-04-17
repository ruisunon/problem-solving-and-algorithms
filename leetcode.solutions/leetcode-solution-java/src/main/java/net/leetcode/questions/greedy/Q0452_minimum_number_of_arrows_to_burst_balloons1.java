package net.leetcode.questions.greedy;

import java.util.Arrays;
import java.util.Comparator;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * @author liwei
 * @date 18/6/25 下午2:46
 */
public class Q0452_minimum_number_of_arrows_to_burst_balloons1 {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }

        // 按照区间起点进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[0] != point2[0]) {
                    return point1[0] - point2[0];
                }
                return point1[1] - point2[1];
            }
        });

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] <= end) {
                // 特别注意：这里应该取最小。
                // 此时不用浪费箭，用之前的箭就可以了。
                end = Math.min(end, points[i][1]);
            } else {
                // 就得多用一支箭
                end = points[i][1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int minArrowShots = solution2.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}
