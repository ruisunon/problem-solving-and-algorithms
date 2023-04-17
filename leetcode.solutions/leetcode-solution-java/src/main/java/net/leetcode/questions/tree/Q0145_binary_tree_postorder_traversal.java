package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.List;

public class Q0145_binary_tree_postorder_traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        dfs(node.right, res);
        res.add(node.val);
    }
}
