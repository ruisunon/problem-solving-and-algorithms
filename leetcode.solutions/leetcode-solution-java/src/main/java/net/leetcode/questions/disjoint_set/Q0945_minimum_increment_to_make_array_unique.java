package net.leetcode.questions.disjoint_set;
import java.util.Arrays;
// Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
//
//    Return the least number of moves to make every value in A unique.
//
//
//
//    Example 1:
//
//    Input: [1,2,2]
//    Output: 1
//    Explanation:  After 1 move, the array could be [1, 2, 3].
//    Example 2:
//
//    Input: [3,2,1,2,1,7]
//    Output: 6
//    Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
//    It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

public class Q0945_minimum_increment_to_make_array_unique {

    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(A);
        // System.out.println(Arrays.toString(A));

        int preNum = A[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            // preNum + 1 表示当前数「最好」是这个值

            if (A[i] == preNum + 1) {
                preNum = A[i];
            } else if (A[i] > preNum + 1) {
                // 当前这个数已经足够大，这种情况可以合并到上一个分支
                preNum = A[i];
            } else {
                // A[i] < preNum + 1
                res += (preNum + 1 - A[i]);
                preNum++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q0945_minimum_increment_to_make_array_unique solution = new Q0945_minimum_increment_to_make_array_unique();
        int[] A = new int[]{1, 2, 2};
        // int[] A = new int[]{3, 2, 1, 2, 1, 7};
        int res = solution.minIncrementForUnique(A);
        System.out.println(res);
    }
}
