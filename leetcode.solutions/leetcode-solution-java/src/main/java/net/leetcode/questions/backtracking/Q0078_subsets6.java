package net.leetcode.questions.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0078_subsets6 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, len, path, res);
        return res;
    }

    private void dfs(int[] nums,
                     int index,
                     int len,
                     Deque<Integer> stack,
                     List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 当前数可选，也可以不选
        // 选了有，进入下一层
        stack.addLast(nums[index]);
        dfs(nums, index + 1, len, stack, res);
        stack.removeLast();

        // 不选，直接进入下一层
        dfs(nums, index + 1, len, stack, res);
    }
}
