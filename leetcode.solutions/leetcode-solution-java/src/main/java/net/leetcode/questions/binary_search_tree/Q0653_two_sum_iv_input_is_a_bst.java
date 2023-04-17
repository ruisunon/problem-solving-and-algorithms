package net.leetcode.questions.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Q0653_two_sum_iv_input_is_a_bst {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        // 使用中序遍历，得到一个顺序数组
        inOrder(root, list);
        int len = list.size();
        int left = 0;
        int right = len - 1;

        // 在顺序数组中，使用二分查找法
        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                assert sum == k;
                return true;
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}