package net.leetcode.questions.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0859_buddy_strings {

    public boolean buddyStrings(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        if (alen != blen) {
            return false;
        }
        if (alen == 0 || alen == 1) {
            return false;
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < alen; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                indexes.add(i);
                if (indexes.size() > 2) {
                    return false;
                }
            }
        }

        if (indexes.size() == 0) {
            // 说明两个字符串相等，能找到两个一样的字母就可以了
            Set<Character> set = new HashSet<>();
            for (Character c : A.toCharArray()) {
                if (!set.add(c)) {
                    return true;
                }
            }
            return false;
        }

        if (indexes.size() != 2) {
            return false;
        }
        int index1 = indexes.get(0);
        int index2 = indexes.get(1);
        return A.charAt(index1) == B.charAt(index2) &&
                A.charAt(index2) == B.charAt(index1);
    }

    public static void main(String[] args) {
        String A = "ab";
        String B = "ab";
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean buddyStrings = solution.buddyStrings(A, B);
        System.out.println(buddyStrings);
    }
}
