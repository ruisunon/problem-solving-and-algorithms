package net.leetcode.questions.greedy;

public class Q0045_jump_game_ii1 {

    public int jump(int[] nums) {
        int len = nums.length;
        int p = len - 1;
        int res = 0;
        while (p > 0) {
            for (int j = 0; j < p; j++) {
                if (j + nums[j] >= p) {
                    res++;
                    p = j;
                    break;
                }
            }
        }
        return res;
    }
}
