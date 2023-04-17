package net.leetcode.questions.bucket_sort;

import net.leetcode.questions.array.Q0027_remove_element;

/**
 * @author liweiwei1419
 * @date 2019/10/4 3:47 下午
 */
public class Q0268_missing_number {

    public int missingNumber(int[] nums) {
        int len = nums.length;

        int sum = 0;
        for (int i = 1; i <= len; i++) {
            sum += i;
        }

        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.missingNumber(nums);
        System.out.println(res);
    }
}
