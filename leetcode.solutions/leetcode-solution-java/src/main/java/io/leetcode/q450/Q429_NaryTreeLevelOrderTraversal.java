package io.leetcode.q450;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.runner.RunWith;
import util.provided.Nary;
import util.provided.Nary.Node;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated
 * by the null value (See examples).
 *
 *
 * Example 1:
 *
 * (图 Q429_PIC1.png)
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * Example 2:
 *
 * (图 Q429_PIC2.png)
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 *
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */
@RunWith(LeetCodeRunner.class)
public class Q429_NaryTreeLevelOrderTraversal {

    @Answer
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node node = queue.remove();
                level.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res.add(level);
        }
        return res;
    }

    @TestData
    public DataExpectation example1 = DataExpectation.create(Nary.createNodeByLevel(1, null,
            3, 2, 4, null,
            5, 6, null)).expect(new int[][]{
            {1},
            {3, 2, 4},
            {5, 6}
    });

    @TestData
    public DataExpectation example2 = DataExpectation.create(Nary.createNodeByLevel(1, null,
            2, 3, 4, 5, null,
            null, 6, 7, null, 8, null, 9, 10, null,
            null, 11, null, 12, null, 13, null, null,
            14, null)).expect(new int[][]{
            {1},
            {2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13},
            {14}
    });

    @TestData
    public DataExpectation border = DataExpectation.create(null).expect(new int[0]);

}
