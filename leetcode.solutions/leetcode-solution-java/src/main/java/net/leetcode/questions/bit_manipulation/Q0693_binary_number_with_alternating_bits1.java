package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * @author liwei
 * @date 18/6/29 下午8:43
 */
public class Q0693_binary_number_with_alternating_bits1 {

    public boolean hasAlternatingBits(int n) {
        String nStr = Integer.toBinaryString(n);
        int len = nStr.length();
        for (int i = 0; i < len - 1; i++) {
            if (nStr.charAt(i) == nStr.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int n = 5;
        solution2.hasAlternatingBits(n);
    }
}
