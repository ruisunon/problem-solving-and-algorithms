package net.leetcode.questions.bit_manipulation;

/**
 * @author liwei
 * @date 18/6/29 下午9:05
 */
public class Q0693_binary_number_with_alternating_bits2 {

    public boolean hasAlternatingBits(int n) {
        String nStr = Integer.toBinaryString(n);
        // 因为是正数，所以一定以 1 开头
        return nStr.matches("(10)*1?");
    }
}
