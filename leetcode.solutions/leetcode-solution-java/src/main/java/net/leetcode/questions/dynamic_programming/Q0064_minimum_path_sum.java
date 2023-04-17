package net.leetcode.questions.dynamic_programming;// 直接在 grid 数组上操作

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0064_minimum_path_sum {

    // 1,3,1
    // 1 5 1

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        Q0027_remove_element solution = new Q0027_remove_element();
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }
}
