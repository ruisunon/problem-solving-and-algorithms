package io.leetcode.q800;

import org.junit.runner.RunWith;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/escape-the-ghosts/
 *
 * You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0],
 * target[1]). There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).
 *
 * Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or
 * south, going from the previous point to a new point 1 unit of distance away.
 *
 * You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts
 * may take.)  If you reach any square (including the target) at the same time as a ghost, it doesn't count as an
 * escape.
 *
 * Return True if and only if it is possible to escape.
 *
 * Example 1:
 * Input:
 * ghosts = [[1, 0], [0, 3]]
 * target = [0, 1]
 * Output: true
 * Explanation:
 * You can directly reach the destination (0, 1) at time 1, while the ghosts located at (1, 0) or (0, 3) have no way
 * to catch up with you.
 *
 * Example 2:
 * Input:
 * ghosts = [[1, 0]]
 * target = [2, 0]
 * Output: false
 * Explanation:
 * You need to reach the destination (2, 0), but the ghost at (1, 0) lies between you and the destination.
 *
 * Example 3:
 * Input:
 * ghosts = [[2, 0]]
 * target = [1, 0]
 * Output: false
 * Explanation:
 * The ghost can reach the target at the same time as you.
 *
 * Note:
 *
 * All points have coordinates with absolute value <= 10000.
 * The number of ghosts will not exceed 100.
 */
@RunWith(LeetCodeRunner.class)
public class Q789_EscapeTheGhosts {

    @Answer
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int steps = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= steps) {
                return false;
            }
        }
        return true;
    }

    @TestData
    public DataExpectation example1 = DataExpectation
            .createWith(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}).expect(true);

    @TestData
    public DataExpectation example2 = DataExpectation.createWith(new int[][]{{1, 0}}, new int[]{2, 0}).expect(false);

    @TestData
    public DataExpectation example3 = DataExpectation.createWith(new int[][]{{2, 0}}, new int[]{1, 0}).expect(false);

}
