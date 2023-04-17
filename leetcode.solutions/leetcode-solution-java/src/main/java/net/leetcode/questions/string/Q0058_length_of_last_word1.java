package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0058_length_of_last_word1 {

    public int lengthOfLastWord(String s) {
        int len = s.length();
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len--;
        }
        if (len == 0) {
            return 0;
        }
        int res = 0;
        while (len > 0 && s.charAt(len - 1) != ' ') {
            res++;
            len--;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "a ";
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int lengthOfLastWord = solution2.lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }
}
