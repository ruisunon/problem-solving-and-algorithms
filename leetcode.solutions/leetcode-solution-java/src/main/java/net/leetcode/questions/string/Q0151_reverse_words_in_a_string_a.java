package net.leetcode.questions.string;

import java.util.Arrays;
import java.util.Collections;

public class Q0151_reverse_words_in_a_string_a {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}


