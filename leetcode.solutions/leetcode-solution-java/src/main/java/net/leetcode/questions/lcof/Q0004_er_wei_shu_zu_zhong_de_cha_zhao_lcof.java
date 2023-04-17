package net.leetcode.questions.lcof;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0004_er_wei_shu_zu_zhong_de_cha_zhao_lcof {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        // 从左下角开始查找
        int x = rows - 1;
        int y = 0;

        while (x >= 0) {

            while (y < cols && matrix[x][y] < target) {
                y++;
            }

            if (y < cols && matrix[x][y] == target) {
                return true;
            }

            x--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        Q0027_remove_element solution = new Q0027_remove_element();
        boolean find = solution.findNumberIn2DArray(matrix, 16);
        System.out.println(find);
    }
}
