package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2019/10/31 6:32 下午
 */
public class Q0515_find_largest_value_in_each_tree_row {

    // 层序优先遍历（广度优先遍历）

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > maxVal) {
                    maxVal = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);

                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(maxVal);
        }
        return res;
    }
}
