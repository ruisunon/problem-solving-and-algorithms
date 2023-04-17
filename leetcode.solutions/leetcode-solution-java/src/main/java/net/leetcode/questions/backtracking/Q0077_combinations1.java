package net.leetcode.questions.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0077_combinations1 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 特判
        if (k <= 0 && k > n) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>(k);
        // 从 1 开始
        dfs(n, k, 1, path, res);
        return res;
    }

    /**
     * 从 [1, n] 中选出 k 个数，
     *
     * @param n     从 [1, n] 中选
     * @param k     选出的数字的个数
     * @param begin 当前被选中的起始数字
     * @param path  已经构成的数字列表
     */
    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}