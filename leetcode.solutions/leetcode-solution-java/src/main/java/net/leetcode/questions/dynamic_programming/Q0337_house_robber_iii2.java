package net.leetcode.questions.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Q0337_house_robber_iii2 {

    private Map<Q0322_coin_change2.TreeNode, Integer> memo;

    private int tryRob(Q0322_coin_change2.TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int res = node.val;

        if (node.left != null) {
            res += tryRob(node.left.left) + tryRob(node.left.right);
        }

        if (node.right != null) {
            res += tryRob(node.right.left) + tryRob(node.right.right);
        }

        res = Math.max(res, tryRob(node.left) + tryRob(node.right));
        memo.put(node, res);
        return res;
    }

    public int rob(Q0322_coin_change2.TreeNode root) {
        memo = new HashMap<>();
        return tryRob(root);
    }
}
