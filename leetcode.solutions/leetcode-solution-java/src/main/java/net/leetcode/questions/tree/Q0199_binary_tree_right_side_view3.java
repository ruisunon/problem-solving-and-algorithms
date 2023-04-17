package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0199_binary_tree_right_side_view3 {

    // 思路：我们按照深度优先遍历的顺序，从右边开始遍历
    // 思路很像前、中、后序遍历（他们都是深度优先遍历），只不过我们先从右边开始遍历

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }


    private void dfs(TreeNode node, int level, List<Integer> res) {
        // 如果 node 为空，就直接返回，一定要先写，以减少很多判断
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        }
        // 如果交换下面两行的顺序，那么就得到二叉树的左视图
        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode4;

        Q0199_binary_tree_right_side_view3 solution = new Q0199_binary_tree_right_side_view3();
        List<Integer> rightSideView = solution.rightSideView(treeNode1);
        System.out.println(rightSideView);
    }
}
