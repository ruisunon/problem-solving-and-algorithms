package io.leetcode.q550;

import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/friend-circles/
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in
 * nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the
 * ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of
 * friend circles among all the students.
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *
 * Note:
 *
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
@RunWith(LeetCodeRunner.class)
public class Q547_FriendCircles {

    // dfs 染色解法
    @Answer
    public int findCircleNum(int[][] M) {
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                res++;
                search(M, i);
            }
        }
        return res;
    }

    private void search(int[][] M, int i) {
        if (M[i][i] != 1) {
            return;
        }
        // 标记这个人已经查找过了
        M[i][i] = 0;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                search(M, j);
            }
        }
    }

    // union find 解法
    @Answer
    public int findCircleNum2(int[][] M) {
        final int n = M.length;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    roots[findRoot(roots, j)] = findRoot(roots, i);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (roots[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int findRoot(int[] roots, int i) {
        if (roots[i] == i) {
            return i;
        }
        return roots[i] = findRoot(roots, roots[i]);
    }

    @TestData
    public DataExpectation example1 = DataExpectation.create(new int[][]{
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
    }).expect(2);

    @TestData
    public DataExpectation example2 = DataExpectation.create(new int[][]{
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
    }).expect(1);

    @TestData
    public DataExpectation normal1 = DataExpectation.create(new int[][]{
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
    }).expect(1);

}
