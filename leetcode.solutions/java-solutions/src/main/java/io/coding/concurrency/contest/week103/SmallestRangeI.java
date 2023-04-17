package io.coding.concurrency.contest.week103;

class Solution {

    public static int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        return Math.max((A[A.length-1] - K) - (A[0] + K), 0);
    }
}
