package net.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;
import net.leetcode.questions.two_pointers.Q0042_trapping_rain_water7;

public class Q0093_restore_ip_addresses7 {

    private String s;
    private int n;
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        this.n = s.length();
        this.res = new ArrayList<>();
        dfs(0, 0, "");
        return this.res;
    }

    /**
     * @param start
     * @param depth 当前已经选出了几个 ip 段
     * @param path
     */
    private void dfs(int start, int depth, String path) {
        if (depth == 4) {
            res.add(path.substring(0, path.length() - 1));
            return;
        }

        // 3 - depth 表示剩余的 ip 段个数
        // n - (3 - depth) * 3 表示剩余的 ip 段如果都是 3 位数，当前 ip 段的结束位置（取不到）
        int endMin = Math.max(start + 1, n - (3 - depth) * 3);

        // n - (3 - depth) * 1 表示剩余的 ip 段如果都是 1 位数，当前 ip 段的结束位置（取不到）
        int endMax = Math.min(start + 3, n - (3 - depth));

        for (int i = endMin; i <= endMax; i++) {
            String split = s.substring(start, i);
            int len = split.length();

            if (len > 1 && split.charAt(0) == '0') {
                break;
            }

            if (Integer.parseInt(split) <= 255) {
                dfs(i, depth + 1, path + (split + '.'));
            }
        }
    }

    public static void main(String[] S) {
        Q0042_trapping_rain_water7 solution8 = new Q0042_trapping_rain_water7();
        String s = "25525511135";
        List<String> res = solution8.restoreIpAddresses(s);
        System.out.println(res);
    }
}
