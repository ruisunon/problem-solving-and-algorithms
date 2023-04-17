package net.leetcode.questions.sliding_window;

import java.util.Arrays;
import net.leetcode.questions.dynamic_programming.Q0123_best_time_to_buy_and_sell_stock_iii7;

/**
 * @author liweiwei1419
 * @date 2019/11/26 11:52 下午
 */
public class Q0239_sliding_window_maximum10 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0){
            return new int[0];
        }
        int[] res = new int[len - k + 1];
        // 枚举滑动窗口的终点
        for (int i = k - 1; i < len ; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - k + 1; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i - k + 1] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Q0123_best_time_to_buy_and_sell_stock_iii7
            solution3 = new Q0123_best_time_to_buy_and_sell_stock_iii7();
        int[] res = solution3.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
