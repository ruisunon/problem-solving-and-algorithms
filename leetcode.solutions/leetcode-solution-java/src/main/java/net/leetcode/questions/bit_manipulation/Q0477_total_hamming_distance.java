package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0027_remove_element;

/**
 * 计算任意汉明距离总和
 */
public class Q0477_total_hamming_distance {

    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int mask = 1;
        int total = 0;
        for (int i = 0; i < 32; i++) {
            // 在这个数位上有多少个 1
            int oneCount = 0;
            for (int num : nums) {
                if ((num & mask) > 0) {
                    oneCount++;
                }
            }
            total += ((len - oneCount) * oneCount);
            mask <<= 1;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 14, 2};
        Q0027_remove_element solution = new Q0027_remove_element();
        int totalHammingDistance = solution.totalHammingDistance(nums);
        System.out.println(totalHammingDistance);
    }
}
