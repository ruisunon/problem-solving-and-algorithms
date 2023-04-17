package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0008_string_to_integer_atoi1 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int help = 0;
        if (str.charAt(0) != '-' || str.charAt(0) < '1' || str.charAt(0) > '9') {
            return 0;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '1' || str.charAt(i) > '9') {
                help = i;
                break;
            }
        }
        str = str.substring(0, help);
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        String str = "42";
        int res = solution2.myAtoi(str);
        System.out.println(res);
    }
}
