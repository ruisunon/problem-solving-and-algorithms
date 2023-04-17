package net.leetcode.questions.hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * <p>
 * Created by liwei on 17/9/13.
 */
public class Q0290_word_pattern1 {
    public boolean wordPattern(String pattern, String str) {
        boolean wordPattern = false;
        int patternLength = pattern.length();
        String[] strArray = str.split(" ");
        if (patternLength == strArray.length) {

            Map<Character, String> map1 = new HashMap<>();
            Set<String> uniqueValue = new HashSet<>();
            char[] patternArray = pattern.toCharArray();
            for (int i = 0; i < patternLength; i++) {
                if (map1.containsKey(patternArray[i])) {
                    if (!map1.get(patternArray[i]).equals(strArray[i])) {
                        return wordPattern;
                    }
                } else {
                    if (uniqueValue.contains(strArray[i])) {
                        return wordPattern;
                    }
                    uniqueValue.add(strArray[i]);
                    map1.put(patternArray[i], strArray[i]);
                }
            }
            wordPattern = true;
        }
        return wordPattern;
    }

    public static void main(String[] args) {
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        String pattern = "abba";
        String str = "dog dog dog dog";
        boolean wordPattern = solution2.wordPattern(pattern, str);
        System.out.println(wordPattern);
    }
}
