package net.leetcode.questions.binary_search;// 不符合题目时间复杂度要求的做法
// 但是是常规思路

import java.util.Arrays;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0004_median_of_two_sorted_arrays3 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] merge = new int[m + n];
        System.arraycopy(nums1, 0, merge, 0, m);
        System.arraycopy(nums2, 0, merge, m, n);

        Arrays.sort(merge);

        if (((m + n) & 1) == 1) {
            return merge[(m + n - 1) / 2];
        } else {
            return (double) (merge[(m + n - 1) / 2] + merge[(m + n) / 2]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Q0128_longest_consecutive_sequence4 solution2 = new Q0128_longest_consecutive_sequence4();
        double res = solution2.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
