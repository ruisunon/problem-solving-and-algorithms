package net.leetcode.questions.stack;

import net.leetcode.questions.array.Q0027_remove_element;

public class Q0085_maximal_rectangle {

    public int maximalRectangle(char[][] matrix) {
        

    }

    public static void main(String[] args) {
//        char[][] matrix = new char[][]{
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1', '1'}};


        Q0027_remove_element solution = new Q0027_remove_element();
        int res = solution.maximalRectangle(matrix);
        System.out.println(res);

    }
}
