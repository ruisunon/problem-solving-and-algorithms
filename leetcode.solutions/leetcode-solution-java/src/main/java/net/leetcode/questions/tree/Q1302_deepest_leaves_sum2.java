package net.leetcode.questions.tree;

import java.util.TreeMap;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q1302_deepest_leaves_sum2 {

    // 深度优先遍历

    private TreeMap<Integer, Integer> treeMap;

    public int deepestLeavesSum(TreeNode root) {
        treeMap = new TreeMap<>();
        dfs(root, 1);

        // System.out.println(treeMap);

        return treeMap.get(treeMap.lastKey());
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            treeMap.put(depth, node.val += treeMap.getOrDefault(depth, 0));
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode4.left = treeNode7;

        treeNode3.right = treeNode6;
        treeNode6.right = treeNode8;

        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int res = solution3.deepestLeavesSum(treeNode1);
        System.out.println(res);

    }


}
