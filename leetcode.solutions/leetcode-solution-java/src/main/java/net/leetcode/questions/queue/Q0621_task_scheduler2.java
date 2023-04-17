package net.leetcode.questions.queue;

import java.util.Arrays;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0621_task_scheduler2 {

    // 贪心算法

    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);

        int maxVal = cnt[25] - 1;

        // idle 空闲
        // slots 插槽
        // 至少要占用这么多空闲的插槽
        int idleSlots = maxVal * n;

        // 每次减去一个任务
        for (int i = 24; i >= 0; i--) {
            if (cnt[i] <= 0) {
                break;
            }
            idleSlots -= Math.min(cnt[i], maxVal);
        }

        // 如果还有剩下，就把原来的不上
        if (idleSlots > 0) {
            idleSlots += tasks.length;
        } else {
            // 说明：空闲个数，要讲清楚这里，最好要画图
            idleSlots = tasks.length;
        }
        return idleSlots;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        Q0621_task_scheduler2 solution2 = new Q0621_task_scheduler2();
        int res = solution2.leastInterval(tasks, n);
        System.out.println(res);
    }
}
