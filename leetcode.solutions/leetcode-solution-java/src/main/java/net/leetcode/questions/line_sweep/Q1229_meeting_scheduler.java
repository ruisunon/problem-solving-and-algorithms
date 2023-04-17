package net.leetcode.questions.line_sweep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1229_meeting_scheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<int[]> slots = new ArrayList<>();

        for (int[] slot : slots1) {
            slots.add(new int[]{slot[0], 0});
            slots.add(new int[]{slot[1], 1});
        }

        for (int[] slot : slots2) {
            slots.add(new int[]{slot[0], 0});
            slots.add(new int[]{slot[1], 1});
        }

        slots.sort(Comparator.comparingInt(o -> o[0]));

        // 这条扫描线横穿的区间的个数
        int count = 0;
        int begin = 0;
        List<Integer> res = new ArrayList<>();

        for (int[] slot : slots) {
            if (slot[1] == 0) {
                count++;
                begin = slot[0];
            } else {
                // 遇到结尾事件
                if (count == 2) {
                    if (slot[0] - begin >= duration) {
                        res.add(begin);
                        res.add(begin + duration);
                        return res;
                    }
                }
                // 重要
                count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;
        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> res = solution.minAvailableDuration(slots1, slots2, duration);
        System.out.println(res);
    }
}
