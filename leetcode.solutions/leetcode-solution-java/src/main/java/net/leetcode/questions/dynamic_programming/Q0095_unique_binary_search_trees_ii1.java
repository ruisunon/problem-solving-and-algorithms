package net.leetcode.questions.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Q0095_unique_binary_search_trees_ii1 {

    public List<Q0322_coin_change2.TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<Q0322_coin_change2.TreeNode> generateTrees(int left, int right) {
        List<Q0322_coin_change2.TreeNode> res = new ArrayList<>();
        if (left > right) {
            // 这个位置要占住
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            for (Q0322_coin_change2.TreeNode leftTree : generateTrees(left, i - 1)) {
                for (Q0322_coin_change2.TreeNode rightTree : generateTrees(i + 1, right)) {
                    Q0322_coin_change2.TreeNode root = new Q0322_coin_change2.TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}