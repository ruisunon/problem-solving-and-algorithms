package net.leetcode.questions.greedy;

public class Q0055_jump_game3 {

    // 贪心算法

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
