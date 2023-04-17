package net.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0257_binary_tree_paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<String> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode node, List<String> path, List<String> res) {
        if (node == null) {
            return;
        }
        path.add("" + node.val);
        if (node.left == null && node.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                stringBuilder.append(path.get(i));
                stringBuilder.append("->");
            }
            stringBuilder.delete(stringBuilder.lastIndexOf("->"), stringBuilder.length());
            res.add(stringBuilder.toString());
            return;
        }

        if (node.left != null) {
            dfs(node.left, path, res);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        Q0257_binary_tree_paths solution = new Q0257_binary_tree_paths();
        List<String> binaryTreePaths = solution.binaryTreePaths(node1);
        binaryTreePaths.forEach(System.out::println);
    }
}
