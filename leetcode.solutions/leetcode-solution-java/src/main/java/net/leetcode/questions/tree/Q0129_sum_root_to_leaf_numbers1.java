package net.leetcode.questions.tree;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0129_sum_root_to_leaf_numbers1 {

    private int sumNumbers(TreeNode node, int cumsum) {
        if (node == null) {
            return 0;
        }
        cumsum = 10 * cumsum + node.val;
        if (node.left == null && node.right == null) {
            return cumsum;
        }
        return sumNumbers(node.left, cumsum) + sumNumbers(node.right, cumsum);
    }


    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int result = solution2.sumNumbers(n1);
        System.out.println("得到的结果：" + result);
    }
}
