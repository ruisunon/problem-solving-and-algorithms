package net.leetcode.questions.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0451_sort_characters_by_frequency1 {

    public String frequencySort(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        Comparator<Character> comparator = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o2) - map.get(o1) == 0) {
                    // 要注意：如果出现频次相同，要按字母顺序排序， "loveleetcode" 就是一个很好的测试用例
                    return o1.compareTo(o2);
                }
                // 注意顺序
                return map.get(o2) - map.get(o1);
            }
        };
        Character[] cArr = new Character[len];
        for (int i = 0; i < len; i++) {
            cArr[i] = s.charAt(i);
        }
        Arrays.sort(cArr, comparator);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(cArr[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Q0027_remove_element solution = new Q0027_remove_element();
        String s1 = solution.frequencySort(s);
        System.out.println("最后结果：" + s1);
    }
}
