package net.leetcode.questions.string;

public class Q0387_first_unique_character_in_a_string {

    // 把数组当做哈希表用

    public int firstUniqChar(String s) {

        int[] hashMap = new int[26];
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            hashMap[c - 'a']++;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (hashMap[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
