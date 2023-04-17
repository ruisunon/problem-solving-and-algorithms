package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

/**
 * @author liwei
 * @date 18/7/5 下午10:45
 */
public class Q0168_excel_sheet_column_title {

    // 原理和进制转换是一样的

    private static final int OFFSET = 'A';

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--;
            stringBuilder.append((char) (n % 26 + OFFSET));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        for (int i = 0; i <= 30; i++) {
            String convertToTitle = solution.convertToTitle(i);
            System.out.println(convertToTitle);
        }
    }
}
