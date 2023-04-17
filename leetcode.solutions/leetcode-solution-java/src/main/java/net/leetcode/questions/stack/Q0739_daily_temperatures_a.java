package net.leetcode.questions.stack;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0739_daily_temperatures_a {

    // 暴力解法

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len < 2) {
            return new int[len];
        }

        int[] res = new int[len];
        res[len - 1] = 0;
        for (int i = 0; i < len - 1; i++) {
            int curVal = T[i];
            for (int j = i + 1; j < len; j++) {
                if (T[j] > curVal) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Q0027_remove_element solution = new Q0027_remove_element();
        int[] res = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
