package net.leetcode.questions.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

/**
 * 和 Q0169_majority_element 的思路差不多，也是一个 AC 解
 */
public class Q0336_palindrome_pairs2 {

    /**
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        int len = words.length;
        HashMap<String, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int wordLen = word.length();
            for (int k = 0; k <= wordLen; k++) {
                String wordLeft = word.substring(0, k);
                String wordRight = word.substring(k);
                if (isPalindrome(wordLeft)) {
                    Integer j = map.get(wordRight);
                    if (j != null && j != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(j);
                        pair.add(i);
                        res.add(pair);
                    }
                }
                if (isPalindrome(wordRight)) {
                    Integer j = map.get(wordLeft);
                    // 注意 wordRight.length() != 0 这一步去重
                    if (j != null && j != i && wordRight.length() != 0) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(j);
                        res.add(pair);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String word) {
        int len = word.length();
        if (len == 0) {
            return true;
        }
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a", ""};
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        List<List<Integer>> palindromePairs = solution2.palindromePairs(words);
        System.out.println(palindromePairs);
    }
}
