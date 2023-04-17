package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

/**
 * @author liwei
 * @date 18/7/1 下午7:47
 */
public class Q0190_reverse_bits2 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        // 输入: 43261596
        // 输出: 964176192
        System.out.println(43261596);
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int reverseBits = solution3.reverseBits(43261596);
        System.out.println(reverseBits);
    }
}
