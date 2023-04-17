package net.leetcode.questions.bit_manipulation;

/**
 * @author liwei
 * @date 18/7/1 上午11:59
 */
public class Q0477_total_hamming_distance2 {

    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int mask = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 0 的个数
            int zeros = 0;
            for (int num : nums) {
                if ((num & mask) == 0) {
                    zeros++;
                }
            }
            res += ((len - zeros) * zeros);
            mask <<= 1;
        }
        return res;
    }
}
