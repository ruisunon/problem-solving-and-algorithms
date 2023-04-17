package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author liweiwei1419
 * @date 2019/10/31 6:32 下午
 */
public class Q0515_find_largest_value_in_each_tree_row1 {

    // 深度优先遍历（前序遍历）

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }

        // 注意这里
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));
        }

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
