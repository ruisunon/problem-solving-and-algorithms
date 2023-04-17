package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q0093_restore_ip_addresses6 {

    private List<String> res = new ArrayList<>();
    int a[], n;

    List<String> restoreIpAddresses(String s) {
        int i;
        n = s.length();
        a = new int[n];
        for (i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }

        // System.out.println(Arrays.toString(a));

        dfs(0, 4, "");
        return res;
    }

    /**
     * @param start
     * @param residue
     * @param s
     */
    private void dfs(int start, int residue, String s) {
        if (n - start > 3 * residue || n - start < residue) {
            return;
        }
        int k = a[start++];

        if (residue == 1 && (start == n || k != 0)) {
            for (; start < n; start++) {
                k = k * 10 + a[start];
            }
            if (k < 256) {
                res.add(s + k);
            }
            return;
        }
        if (k == 0) {
            dfs(start, residue - 1, s + "0.");
            return;
        }
        for (; start < n && k < 256; k = k * 10 + a[start++]) {
            dfs(start, residue - 1, s + k + ".");
        }
    }

    public static void main(String[] S) {
        Q0547_friend_circles7 solution7 = new Q0547_friend_circles7();
        String s = "25525511135";
        List<String> res = solution7.restoreIpAddresses(s);
        System.out.println(res);
    }
}
