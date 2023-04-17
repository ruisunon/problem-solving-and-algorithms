package net.leetcode.questions.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Q0230_kth_smallest_element_in_a_bst4 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(k - 1);
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


