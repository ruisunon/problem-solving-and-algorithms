package net.leetcode.questions.greedy;

import java.util.Arrays;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

// 455. 分发饼干
// 思路 2 ：饼干数组和小朋友的贪心指数数组都从大到小排序

public class Q0455_assign_cookies1 {

    // 输入: [1,2,3], [1,1]
    // 输出: 1
    // g 是贪心指数
    // s 是饼干的大小
    public int findContentChildren(int[] g, int[] s) {
        int glen = g.length;
        int slen = s.length;
        if (glen == 0 || slen == 0) {
            return 0;
        }
        // 贪心算法通常都和排序相关

        Arrays.sort(g);
        Arrays.sort(s);

        int[] gNew = new int[glen];
        for (int i = 0; i < glen; i++) {
            gNew[glen - 1 - i] = g[i];
        }
        g = gNew;

        int[] sNew = new int[slen];
        for (int i = 0; i < slen; i++) {
            sNew[slen - 1 - i] = s[i];
        }
        s = sNew;

        int gi = 0;
        int si = 0;
        int res = 0;

        while (gi < glen && si < slen) {
            if (s[si] >= g[gi]) {
                si++;
                gi++;
                res++;
            } else { // 当前这块小的饼干不能满足当前这位小朋友了，所以我们要换下一个胃口小一点的小朋友了
                gi++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        int contentChildren = solution.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
