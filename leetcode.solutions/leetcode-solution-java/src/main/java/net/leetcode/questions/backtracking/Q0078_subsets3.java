package net.leetcode.questions.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0078_subsets3 {

    // 位运算

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        int n = 1 << size;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }
}
