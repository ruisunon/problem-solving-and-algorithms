package net.fp.algorithms.easy.array;

	import java.util.Arrays;
import java.util.function.BiFunction;

	public class FlippingAnImage {

	/*
	    Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
	    To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
	    horizontally results in [0, 1, 1].
	    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1]
	    results in [1, 0, 0].
	    Example 1:
	    Input: [[1,1,0],[1,0,1],[0,0,0]]
	    Output: [[1,0,0],[0,1,0],[1,1,1]]
	    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
	    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
	    Example 2:
	    Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
	    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
	    Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
	    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
	    Notes:
	    1 <= A.length = A[0].length <= 20
	    0 <= A[i][j] <= 1
	*/

	    /**
	     * This is to do 2 operations on a row of an array, reverse and invert
	     * special case is the odd colomns
	     * 
	     * @param A
	     * @return
	     */
	    public int[][] flipAndInvertImage(int[][] matrix) {
	    	int k= matrix.length;
	    	 System.out.println(k);
	        for (int i = 0; i < matrix.length; i++) {
	            int mid = matrix[i].length / 2;
	            for (int j = 0; j < mid; j++) {
	                int temp = matrix[i][j];
	                temp = temp ^ 1;
	                matrix[i][j] = matrix[i][matrix[i].length - 1 - j] ^ 1;
	                matrix[i][matrix[i].length - 1 - j] = temp;
	            }
	            if (matrix[i].length % 2 == 1)
	            	matrix[i][mid] = matrix[i][mid] ^ 1;
	        }
	        return matrix;
	    }

	    public static void main(String[] args) {
	    //  int arr[][] = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
	    //  int arr[][] = {{1}, {0}, {0,}};
	        int arr[][] = {{1, 1, 0, 0, 1}, {1, 0, 0, 1, 0}, {0, 1, 1, 1, 1}, {1, 0, 1, 0,0}};
	        FlippingAnImage flipping_an_image = new FlippingAnImage();
	        int res[][] = flipping_an_image.flipAndInvertImage(arr);
	        for (int i = 0; i < res.length; i++) {
	            System.out.println(Arrays.toString(res[i]));
	        }
	    }
	}