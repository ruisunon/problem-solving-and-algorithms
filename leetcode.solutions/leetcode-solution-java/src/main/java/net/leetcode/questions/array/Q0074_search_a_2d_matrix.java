package net.leetcode.questions.array;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0074_search_a_2d_matrix {

    // 二分法：http://www.cnblogs.com/anne-vista/p/5135310.html

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int x = 0;
        // 注意 matrix[x + 1][0] <= target 这里是等于
        while (x < row - 1 && matrix[x + 1][0] <= target) {
            x++;
        }
        for (int i = 0; i < col; i++) {
            if (matrix[x][i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean searchMatrix = solution.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
