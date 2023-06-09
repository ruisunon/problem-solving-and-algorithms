package io.leetcode.q950;

import org.junit.runner.RunWith;
import io.leetcode.q1000.Q955_DeleteColumnsToMakeSortedII;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * [Easy] 944. Delete Columns to Make Sorted
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 *
 * We are given an array A of N lowercase letter strings, all of the same length.
 *
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 *
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after
 * deletions is ["bef", "vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the
 * c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]]).
 *
 * Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in
 * non-decreasing sorted order.
 *
 * Return the minimum possible value of D.length.
 *
 * Example 1:
 *
 * Input: A = ["cba","daf","ghi"]
 * Output: 1
 * Explanation:
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
 *
 * Example 2:
 *
 * Input: A = ["a","b"]
 * Output: 0
 * Explanation: D = {}
 *
 * Example 3:
 *
 * Input: A = ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation: D = {0, 1, 2}
 *
 * Constraints:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 1000
 *
 * 下一题 {@link Q955_DeleteColumnsToMakeSortedII}
 *
 * 题解: A 中的字符串相同长度, 现在要删除每个字符串中特定列的字符, 让结果字符串中的每列字符按字典序递增排序.
 */
@RunWith(LeetCodeRunner.class)
public class Q944_DeleteColumnsToMakeSorted {

    @Answer
    public int minDeletionSize(String[] A) {
        final int n = A[0].length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }


    @TestData
    public DataExpectation example1 = DataExpectation.create(new String[]{"cba", "daf", "ghi"}).expect(1);

    @TestData
    public DataExpectation example2 = DataExpectation.create(new String[]{"a", "b"}).expect(0);

    @TestData
    public DataExpectation example3 = DataExpectation.create(new String[]{"zyx", "wvu", "tsr"}).expect(3);
}
