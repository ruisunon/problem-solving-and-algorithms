package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * @author liwei
 * @date 18/6/30 上午11:42
 */
public class Q0405_convert_a_number_to_hexadecimal1 {

    // 转换为二进制字符
    public String toBinaryString(int num) {
        // 注意：0 要特殊对待
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            stringBuilder.insert(0, num & 1);
            // 比 2 小的数用二进制表示最多用 1 位
            num >>>= 1;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        for (int i = -1000000; i <= 1000000; i++) {
            String num1 = Integer.toBinaryString(i);
            String num2 = solution2.toBinaryString(i);
            if (!num1.equals(num2)) {
                System.out.println(num1);
                System.out.println(num2);
                throw new RuntimeException("二进制转换出错！");
            }
        }
        System.out.println("正确！");
    }
}
