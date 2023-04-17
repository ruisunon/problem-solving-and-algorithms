package net.leetcode.questions.binary_search;

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q1292_maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold1 {

    public int maxSideLength(int[][] mat, int threshold) {
        // 特判
        int rows = mat.length;
        if (rows == 0) {
            return 0;
        }
        int cols = mat[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] sum = prefixSumMatrix(mat, rows, cols);

        int left = 1;
        int right = Math.min(rows, cols);

        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (check(sum, rows, cols, mid, threshold)) {
                // 返回 true 表示表示至少有一个方阵小于等于 threshold，
                // 下一轮搜索区间是 [mid, right]
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        // 也有可能不存在，因此退出循环以后还须要检查一下
        if (check(sum, rows, cols, left, threshold)) {
            return left;
        }
        return 0;
    }

    /**
     * 计算前缀和矩阵
     *
     * @param mat
     * @param rows
     * @param cols
     * @return
     */
    private int[][] prefixSumMatrix(int[][] mat, int rows, int cols) {
        int[][] prefixSumMatrix = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSumMatrix[i + 1][j + 1] = mat[i][j];
            }
        }

        // 把每一行加到前一行
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSumMatrix[i][j] += prefixSumMatrix[i - 1][j];
            }
        }

        // 把每一列加到前一列
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSumMatrix[i][j] += prefixSumMatrix[i][j - 1];
            }
        }
        return prefixSumMatrix;
    }

    /**
     * 只要检测到有一个子矩阵小于阈值就返回 true
     *
     * @param sum
     * @param rows
     * @param cols
     * @param k
     * @param threshold
     * @return
     */
    private boolean check(int[][] sum, int rows, int cols, int k, int threshold) {
        // 在前缀和矩阵中，下标从 1 开始，到 rows 、cols 结束
        // 注意有偏差 1
        for (int i = 1; i + k - 1 <= rows; i++) {
            for (int j = 1; j + k - 1 <= cols; j++) {
                if (calculateSquareSum(sum, i, j, k) <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 计算子方阵内的元素之和之和
     *
     * @param sum  前缀和矩阵
     * @param x    子方阵左上角的横坐标
     * @param y    子方阵左上角的纵坐标
     * @param side 边长
     * @return
     */
    private int calculateSquareSum(int[][] sum, int x, int y, int side) {
        // 子方阵右下角的横坐标与纵坐标
        int rightBottomX = x + side - 1;
        int rightBottomY = y + side - 1;
        return sum[rightBottomX][rightBottomY] - sum[x - 1][rightBottomY] - sum[rightBottomX][y - 1] + sum[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2}
        };
        int threshold = 4;

//        int[][] mat = {{18, 70}, {61, 1}, {25, 85}, {14, 40}, {11, 96}, {97, 96}, {63, 45}};
//        int threshold = 40184;

//        int[][] mat = {{1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
//        int threshold = 6;
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int res = solution2.maxSideLength(mat, threshold);
        System.out.println(res);
    }
}
