package net.leetcode.questions.tree;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q315_sum_of_mutated_array_closest_to_target3 {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 10_0000;

        while (left < right) {
            int mid = (left + right) >>> 1;
            int sum = calculateSum(arr, mid);

            System.out.println("left = " + left + ", right = " + right + ", sum = " + sum);

            // 计算最后一个小于等于 target 的阈值
            if (sum > target) {
                // 大于的就不是解
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 比较阈值线分别定在 left 和 left + 1 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        int[] arr = {2, 3, 5};
        int target = 10;
        int res = solution4.findBestValue(arr, target);
        System.out.println(res);
    }
}
