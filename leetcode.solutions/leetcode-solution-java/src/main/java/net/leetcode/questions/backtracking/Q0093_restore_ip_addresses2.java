package net.leetcode.questions.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

public class Q0093_restore_ip_addresses2 {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len <= 4) {
            return res;
        }
        int splitTimes = 0;

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, splitTimes, path, res);
        return res;
    }


    private void dfs(String s, int len, int start, int splitTimes, Deque<String> pre, List<String> res) {
        if (start == len) {
            if (splitTimes == 4) {
                res.add(String.join(".", pre));
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (start + i >= len){
                break;
            }

            if (judgeStringIfIpNum(s,start,start + i)) {
                String currentNum = s.substring(start, start + i + 1);
                pre.addLast(currentNum);
                dfs(s, len,start + i + 1, splitTimes + 1, pre,res);
                pre.removeLast();
            }
        }
    }

    private boolean judgeStringIfIpNum(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }


    public static void main(String[] args) {
        String num = "010010";
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        List<String> restoreIpAddresses = solution3.restoreIpAddresses(num);
        for (String s : restoreIpAddresses) {
            System.out.println(s);
        }
    }
}
