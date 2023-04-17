package net.leetcode.questions.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划的解法
 */
public class Q0095_unique_binary_search_trees_ii2 {

    public List<Q0322_coin_change2.TreeNode> generateTrees(int n) {
        List<Q0322_coin_change2.TreeNode>[] res = new ArrayList[n + 1];
        res[0] = new ArrayList<>();
        if (n <= 0) {
            return res[0];
        }
        // 注意这个位置
        res[0].add(null);
        for (int i = 1; i <= n; i++) {
            // 先将对象数组初始化
            res[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (Q0322_coin_change2.TreeNode left : res[j]) {
                    for (Q0322_coin_change2.TreeNode right : res[i - j - 1]) {
                        Q0322_coin_change2.TreeNode root = new Q0322_coin_change2.TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        res[i].add(root);
                    }
                }
            }
        }
        return res[n];
    }

    private Q0322_coin_change2.TreeNode clone(Q0322_coin_change2.TreeNode root, int k) {
        if (root == null) {
            return root;
        }
        Q0322_coin_change2.TreeNode curNode = new Q0322_coin_change2.TreeNode(root.val + k);
        curNode.left = clone(root.left, k);
        curNode.right = clone(root.right, k);
        return curNode;
    }
}
