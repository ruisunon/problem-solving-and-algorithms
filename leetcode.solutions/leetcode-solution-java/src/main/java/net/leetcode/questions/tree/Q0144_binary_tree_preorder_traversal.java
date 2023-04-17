package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.List;

public class Q0144_binary_tree_preorder_traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        res.add(treeNode.val);
        dfs(treeNode.left, res);
        dfs(treeNode.right, res);
    }
}
