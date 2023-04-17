package net.leetcode.questions.hash_table;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0974_subarray_sums_divisible_by_k {

    // 超时

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = sum(A, i, j);
                if ((sum % K) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private int sum(int[] A, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += A[i];

        }
        return sum;
    }

    public static void main(String[] args) {

//        int[] A = new int[]{4, 5, 0, -2, -3, 1};
//        int K = 5;

        int[] A = new int[]{-5};
        int K = 5;
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.subarraysDivByK(A, K);
        System.out.println(res);
    }
}
