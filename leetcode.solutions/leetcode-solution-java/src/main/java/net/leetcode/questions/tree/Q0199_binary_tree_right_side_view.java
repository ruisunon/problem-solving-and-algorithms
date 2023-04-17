package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;


public class Q0199_binary_tree_right_side_view {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                // 如果写成 i == 0 就得到左边的视图
                if (i == size - 1) {
                    res.add(curNode.val);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return res;
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

        Q0199_binary_tree_right_side_view solution2 = new Q0199_binary_tree_right_side_view();
        List<Integer> rightSideView = solution2.rightSideView(treeNode1);
        System.out.println(rightSideView);
    }
}