package net.leetcode.questions.lcci;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q_08_04_power_set_lcci2 {

    // 位运算

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;

        int size = 1 << len;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>(len);

            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                subset.add(nums[j]);
            }
            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = solution3.subsets(nums);
        System.out.println(res);
    }
}
