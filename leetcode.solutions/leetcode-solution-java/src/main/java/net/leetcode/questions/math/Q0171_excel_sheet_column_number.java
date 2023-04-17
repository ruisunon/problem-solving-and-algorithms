package net.leetcode.questions.math;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0171_excel_sheet_column_number {

    // 利用 ASCII 码做一个偏移常量
    private static final int OFFSET = (int) 'A' - 1;

    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int curVal = s.charAt(i) - OFFSET;
            res = res * 26 + curVal;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(OFFSET);
        Q0027_remove_element solution = new Q0027_remove_element();
        String s = "ZY";
        int titleToNumber = solution.titleToNumber(s);
        System.out.println(titleToNumber);
    }
}
