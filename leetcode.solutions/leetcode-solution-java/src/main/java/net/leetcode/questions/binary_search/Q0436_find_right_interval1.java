package net.leetcode.questions.binary_search;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0436_find_right_interval1 {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            treeMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
            if (entry == null) {
                res[i] = -1;
            } else {
                res[i] = entry.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        // int[][] intervals = {{1, 4}, {2, 3}, {3, 4}};
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        int[] res = solution.findRightInterval(intervals);
        System.out.println(Arrays.toString(res));
    }
}
