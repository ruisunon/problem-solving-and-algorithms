package net.leetcode.questions.math;

public class Q0292_nim_game {

    // https://blog.csdn.net/fly_yr/article/details/50071367

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
