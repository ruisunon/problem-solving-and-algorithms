package net.leetcode.questions.hash_table;

import java.util.List;
import java.util.Scanner;

public class Q1248_count_number_of_nice_subarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int[] dp = new int[month + 1];

        return 0;
    }


    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);


        int res = cols;
        for (int i = 0; i < rows; i++) {

            int left = 0;
            int right = cols - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (binaryMatrix.get(i, mid) == 0) {

                    // [mid + 1, right]
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (binaryMatrix.get(i, left) == 1) {
                res = Math.min(res, left);
            }

        }

        if (res == cols) {
            return -1;
        }
        return res;
    }

}
