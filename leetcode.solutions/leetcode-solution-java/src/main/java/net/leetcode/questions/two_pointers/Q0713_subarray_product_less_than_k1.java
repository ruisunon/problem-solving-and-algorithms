package net.leetcode.questions.two_pointers;

/**
 * @author liweiwei1419
 * @date 2019/9/20 3:15 下午
 */
public class Q0713_subarray_product_less_than_k1 {

    // 滑动窗口模板

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int count = 0;
        int product = 1;
        for (int right = 0; right < len; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
