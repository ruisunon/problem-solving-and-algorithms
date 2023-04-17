package net.leetcode.questions.hash_table;

import java.util.HashMap;
import java.util.Map;

public class Q0387_first_unique_character_in_a_string1 {

    public int firstUniqChar(String s) {
        int len = s.length();

        // 计数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
