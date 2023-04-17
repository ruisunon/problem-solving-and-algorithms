package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0190_reverse_bits1 {
    // you need treat n as an unsigned value

    public int reverseBits(int n) {
        // 0 其实不用特殊考虑
        if (n == 0) {
            return 0;
        }
        int res = 0;
        // 这里不能使用 while(n!=0) ，因为我们要考虑到最高位补 0 的情况
        for (int i = 0; i < 32; i++) {
            // 先左移，让出位置来
            res <<= 1;
            // 当前考虑的这个数位是 0 还是 1
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int n = 43261596;
        int reverseBits = solution2.reverseBits(n);
        System.out.println(reverseBits);
    }
}