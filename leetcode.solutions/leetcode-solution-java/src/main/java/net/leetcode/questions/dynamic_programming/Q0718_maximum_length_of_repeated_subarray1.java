package net.leetcode.questions.dynamic_programming;

public class Q0718_maximum_length_of_repeated_subarray1 {

    // 滑动窗口

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxLen = maxLength(A, B, i, 0, len);
            res = Math.max(res, maxLen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(A, B, 0, i, len);
            res = Math.max(res, maxLen);
        }
        return res;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

}
