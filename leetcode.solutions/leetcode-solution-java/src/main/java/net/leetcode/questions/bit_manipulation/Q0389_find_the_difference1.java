package net.leetcode.questions.bit_manipulation;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0389_find_the_difference1 {

    // 在编写注释的过程中发现，其实 char 就是整型数字，因此根本不用做转换

    public char findTheDifference(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int res = t.charAt(0);
        for (int i = 0; i < slen; i++) {
            res ^= (s.charAt(i));
        }
        for (int i = 1; i < tlen; i++) {
            res ^= (t.charAt(i));
        }
        return (char) (res);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        char theDifference = solution.findTheDifference(s, t);
        System.out.println(theDifference);
    }
}