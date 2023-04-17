package net.leetcode.questions.math;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0319_bulb_switcher {

    public int bulbSwitch(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j < n; j += i) {
                nums[j] ^= 1;
            }
            System.out.println(Arrays.toString(nums));
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 8;
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.bulbSwitch(n);
        System.out.println(res);

    }
}
