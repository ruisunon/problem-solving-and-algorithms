package net.leetcode.questions.lcof;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0062_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof2 {

    int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int n = 70866;
        int m = 116922;
        // 64165
//        int n = 10;
//        int m = 17;
        int lastRemainingSolution = solution3.lastRemaining(n, m);
        System.out.println(lastRemainingSolution);
    }
}
