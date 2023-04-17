package net.leetcode.questions.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0040_combination_sum_ii2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int len = candidates.length;
        dfs(candidates, target, 0, len, new ArrayDeque<>(len), res);
        return res;
    }

    private void dfs(int[] candidates, int residue, int begin, int len, Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            residue -= candidates[i];
            path.addLast(candidates[i]);

            dfs(candidates, residue, i + 1, len, path, res);

            path.removeLast();
            residue += candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Q0027_remove_element solution = new Q0027_remove_element();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
