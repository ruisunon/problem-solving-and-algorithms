package net.leetcode.questions.dynamic_programming;

import java.util.Arrays;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0518_coin_change23 {

    // 该解法超时，要看问题规模

    private int res = 0;

    public int change(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);

        backtracking(amount, coins, 0, len);
        return res;
    }

    private void backtracking(int residue, int[] coins, int start, int len) {
        if (residue == 0) {
            res++;
            return;
        }

        for (int i = start; i < len; i++) {
            if (residue - coins[i] < 0) {
                break;
            }
            backtracking(residue - coins[i], coins, i, len);
        }
    }

    public static void main(String[] args) {
        int amount = 500;
        int[] coins = {3, 5, 7, 8, 9, 10, 11};
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        int res = solution4.change(amount, coins);
        System.out.println(res);
    }
}
