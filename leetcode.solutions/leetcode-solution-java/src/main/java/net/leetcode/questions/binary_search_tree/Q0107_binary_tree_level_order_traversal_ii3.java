package net.leetcode.questions.binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Q0107_binary_tree_level_order_traversal_ii3 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode top = queue.removeFirst();
                curLevel.add(top.val);
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            res.addFirst(curLevel);
        }
        return res;
    }
}