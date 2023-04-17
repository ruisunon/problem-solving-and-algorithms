package net.leetcode.questions.two_pointers;

import net.leetcode.questions.array.Q0027_remove_element;

/**
 * @author liweiwei1419
 * @date 2019/9/20 3:08 下午
 */
public class Q0713_subarray_product_less_than_k {

    /**
     * 暴力解法：超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                int product = 1;
                for (int i = left; i <= right; i++) {
                    product *= nums[i];
                }
                // 注意：乘积可能越界
                if (product > 0 && product < k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }
}
