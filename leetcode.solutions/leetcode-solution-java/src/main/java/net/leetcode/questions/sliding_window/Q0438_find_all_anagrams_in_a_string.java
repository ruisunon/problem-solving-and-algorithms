package net.leetcode.questions.sliding_window;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0438_find_all_anagrams_in_a_string {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen == 0 || pLen == 0 || sLen < pLen) {
            return res;
        }


        char[] charArrayS = s.toCharArray();
        char[] charArrayP = p.toCharArray();

        int[] pFreq = new int[128];
        int[] winFreq = new int[128];

        for (char c : charArrayP) {
            pFreq[c]++;
        }

        int left = 0;
        int right = 0;
        int distance = 0;

        while (right < sLen) {
            if (pFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }

            if (winFreq[charArrayS[right]] < pFreq[charArrayS[right]]) {
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while (distance == pLen) {
                if (right - left == pLen) {
                    res.add(left);
                }

                if (pFreq[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }

                if (winFreq[charArrayS[left]] == pFreq[charArrayS[left]]) {
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        Q0027_remove_element solution = new Q0027_remove_element();
        List<Integer> res = solution.findAnagrams(s, p);
        System.out.println(res);

        System.out.println((int) 'a');
        System.out.println((int) 'z');
    }
}
