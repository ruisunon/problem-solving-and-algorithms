package net.leetcode.questions.lcof;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0062_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof1 {

    /**
     * 删除第 m 个数字
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {

        int[] arr = new int[n];
        List<Integer> res = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            arr[i] = i ;
        }


        int i = 0;

        for (int j = 0; j < n - 1; j++) {
            // 计数器
            int count = 0;

            while (count < m) {
                if (arr[i] > 0) {
                    count++;

                    if (count == m) {
                        res.add(arr[i]);
                        arr[i] = 0;
                    }
                }
                i++;
                i %= n;
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != 0) {
                res.add(arr[j]);
            }
        }

        return res.get(n- 1);
    }


    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int res = solution2.lastRemaining(n, m);
        System.out.println(res);
    }
}
