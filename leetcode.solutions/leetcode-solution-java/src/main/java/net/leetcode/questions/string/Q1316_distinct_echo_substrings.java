package net.leetcode.questions.string;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q1316_distinct_echo_substrings {

    public int distinctEchoSubstrings(String text) {
        int len = text.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len ; j++) {
                System.out.println(text.substring(i,j + 1));

                for (int k = 2; k < ; k++) {

                }

            }
            System.out.println();
        }



        return 0;
    }

    private boolean check(){

    }


    public static void main(String[] args) {
        String text = "abcabcabc";

        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.distinctEchoSubstrings(text);
        System.out.println(res);
    }
}
