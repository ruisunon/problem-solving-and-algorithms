package net.leetcode.questions.hash_table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author liwei
 * @date 18/7/1 上午9:36
 */
public class Q0187_repeated_dna_sequences1 {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        int len = s.length();
        for (int i = 0; i + 9 < len; i++) {
            String segment = s.substring(i, i + 10);
            if (!seen.add(segment)) {
                repeated.add(segment);
            }
        }
        return new ArrayList<>(repeated);
    }
}
