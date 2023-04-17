package net.leetcode.questions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0819_most_common_word {

    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        String[] ps = paragraph.toLowerCase().split("[^a-z]");
        // 注意会有空的字符串出现
        // System.out.println(Arrays.toString(ps));
        for (String p : ps) {
            if ("".equals(p)) {
                continue;
            }
            if (!set.contains(p)) {
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                } else {
                    map.put(p, 1);
                }
            }
        }
        int max = 0;
        String mcw = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mcw = entry.getKey();
            }
        }
        return mcw;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        Q0027_remove_element solution = new Q0027_remove_element();
        String mostCommonWord = solution.mostCommonWord(paragraph, banned);
        System.out.println(mostCommonWord);
    }
}
