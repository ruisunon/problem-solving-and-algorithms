package net.leetcode.questions.math;

public class Q0268_missing_number {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n + 1) * n / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
