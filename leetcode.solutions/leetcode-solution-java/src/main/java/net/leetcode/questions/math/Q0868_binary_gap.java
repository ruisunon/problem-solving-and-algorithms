package net.leetcode.questions.math;

import java.util.Arrays;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0868_binary_gap {

    // 参考解答：https://leetcode-cn.com/articles/binary-gap/

    public int[][] transpose(int[][] A) {
        int row = A.length;
        if (row == 0) {
            return new int[0][0];
        }
        int col = A[0].length;
        int[][] matrix = new int[col][row];
        // 遍历还是按照原来的方式遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 按照转置的方式填写转置矩阵就可以了
                matrix[j][i] = A[i][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Q0027_remove_element solution = new Q0027_remove_element();
        int[][] transpose = solution.transpose(matrix);
        for (int i = 0; i < transpose.length; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }
    }
}
