package net.leetcode.questions.array;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0466_count_the_repetitions1 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        int index1 = 0;
        int index2 = 0;

        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < len1; j++) {
                if (s1.charAt(j) == s2.charAt(index1)) {
                    index1++;
                }
                if (index1 == len2) {
                    index1 = 0;
                    index2++;
                }
            }
        }
        return index2 / n2;
    }

    public static void main(String[] args) {
        String s1 = "acb";
        int n1 = 4;

        String s2 = "ab";
        int n2 = 2;

        Q0026_remove_duplicates_from_sorted_array2 solution = new Q0026_remove_duplicates_from_sorted_array2();
        int res = solution.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println(res);
    }
}
