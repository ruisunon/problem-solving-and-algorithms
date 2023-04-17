package net.leetcode.questions.array;

import java.util.ArrayList;
import java.util.List;
//   Given an initial array arr, every day you produce a new array using the array of the previous day.
//    On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:
//    If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
//    If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
//    The first and last elements never change.
//    After some days, the array does not change. Return that final array.
//    Example 1:
//    Input: arr = [6,2,3,4]
//    Output: [6,3,3,4]
//    Explanation:
//    On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
//    No more operations can be done to this array.
//    Example 2:
//    Input: arr = [1,6,3,4,3,5]
//    Output: [1,4,4,4,4,5]
//    Explanation:
//    On the first day, the array is changed from [1,6,3,4,3,5] to [1,5,4,3,4,5].
//    On the second day, the array is changed from [1,5,4,3,4,5] to [1,4,4,4,4,5].
//    No more operations can be done to this array.
//    Constraints:
//    1 <= arr.length <= 100
//    1 <= arr[i] <= 100

public class Q1243_array_transformation {

    public List<Integer> transformArray(int[] arr) {
        int len = arr.length;

        // 默认的语义是有变化
        boolean change = true;

        // 因为 arr[i] 的变化要看它两边的值，如果原地修改，就不符合题意
        // 需要辅助数组
        int[] temp = new int[len];
        while (change) {
            change = false;
            // 因为两边不变，只用复制中间的即可，不能写成 temp = arr;
            System.arraycopy(arr, 1, temp, 1, len - 1);
            for (int i = 1; i < len - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    temp[i]++;
                    change = true;
                }

                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    temp[i]--;
                    change = true;
                }
            }
            // 再复制回去，不能写成 arr = temp;
            System.arraycopy(temp, 1, arr, 1, len - 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {2, 1, 2, 1, 1, 2, 2, 1};
        int[] arr = {1, 6, 3, 4, 3, 5};
        Q1243_array_transformation solution = new Q1243_array_transformation();
        List<Integer> res = solution.transformArray(arr);
        System.out.println(res);
    }
}
