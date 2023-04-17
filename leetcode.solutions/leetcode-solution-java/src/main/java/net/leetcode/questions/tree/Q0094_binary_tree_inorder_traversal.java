package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.List;


public class Q0094_binary_tree_inorder_traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
}
