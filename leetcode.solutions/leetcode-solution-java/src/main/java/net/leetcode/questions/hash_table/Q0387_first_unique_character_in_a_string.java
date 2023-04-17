package net.leetcode.questions.hash_table;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0387_first_unique_character_in_a_string {

    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return 0;
        }

        int[] map = new int[26];

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        Q0027_remove_element solution = new Q0027_remove_element();
        int firstUniqChar = solution.firstUniqChar(str);
        System.out.println(firstUniqChar);
    }
}