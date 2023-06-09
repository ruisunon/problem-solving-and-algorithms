package io.leetcode.q500;

import java.util.Arrays;
import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 *
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
 * please find out a way you can make one square by using up all those matchsticks. You should not break any stick,
 * but you can link them up, and each matchstick must be used exactly one time.
 *
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either
 * be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 *
 * Example 1:
 *
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 *
 * Example 2:
 *
 * Input: [3,3,3,3,4]
 * Output: false
 *
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 *
 * Note:
 *
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 */
@RunWith(LeetCodeRunner.class)
public class Q473_MatchsticksToSquare {

    // https://www.cnblogs.com/grandyang/p/6238425.html
    // 递归调用判断
    @Answer
    public boolean makesquare(int[] nums) {
        // 边界检查与准备工作
        if (nums.length < 4) {
            return false;
        }
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 4 > 0) {
            return false;
        }
        int target = (int) (total / 4);
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }

        return dfs(nums, new int[4], nums.length - 1, target);
    }

    // 从尾到前遍历, 避免超时
    boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index < 0) {
            return sums[0] == target
                    && sums[1] == target
                    && sums[2] == target;
        }
        // 把当前数字分别加到4 个边上去, 找出符合条件的组合.
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= target) {
                sums[i] += nums[index];
                if (dfs(nums, sums, index - 1, target)) {
                    return true;
                }
                sums[i] -= nums[index];
            }
        }
        return false;
    }

    @TestData
    public DataExpectation example1 = DataExpectation.create(new int[]{1, 1, 2, 2, 2}).expect(true);

    @TestData
    public DataExpectation example2 = DataExpectation.create(new int[]{3, 3, 3, 3, 4}).expect(false);

}
