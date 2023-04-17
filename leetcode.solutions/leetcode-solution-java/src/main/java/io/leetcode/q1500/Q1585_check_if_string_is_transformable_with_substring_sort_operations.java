package io.leetcode.q1500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

//   Given two strings s and t, you want to transform string s into string t using the following operation any number of times:
//    Choose a non-empty substring in s and sort it in-place so the characters are in ascending order.
//    For example, applying the operation on the underlined substring in "14234" results in "12344".
//
//    Return true if it is possible to transform string s into string t. Otherwise, return false.
//    A substring is a contiguous sequence of characters within a string.
//
//    Example 1:
//
//    Input: s = "84532", t = "34852"
//    Output: true
//    Explanation: You can transform s into t using the following sort operations:
//    "84532" (from index 2 to 3) -> "84352"
//    "84352" (from index 0 to 2) -> "34852"
//    Example 2:
//
//    Input: s = "34521", t = "23415"
//    Output: true
//    Explanation: You can transform s into t using the following sort operations:
//    "34521" -> "23451"
//    "23451" -> "23415"
//    Example 3:
//
//    Input: s = "12345", t = "12435"
//    Output: false
//    Example 4:
//
//    Input: s = "1", t = "2"
//    Output: false
//
//    Constraints:
//
//    s.length == t.length
//    1 <= s.length <= 105
//    s and t only contain digits from '0' to '9'.
public class Q1585_check_if_string_is_transformable_with_substring_sort_operations {

  public boolean isTransformable(String s, String t) {
    int len=s.length();
    List<Queue<Integer>> queues = new ArrayList<Queue<Integer>>();
    for(int i = 0; i <10; i++){
      queues.add(i, new LinkedList<Integer>());
    }
    for(int i=0; i<len; i++){
      queues.get(s.charAt(i)-'0').add(i);
    }
    for(int k=0; k<len; k++) {
      int d = t.charAt(k) - '0';
      if (queues.get(d).size()<1) return false;
      Integer target = (Integer) queues.get(d).peek();
      for (int j = 0; j < d; j++) {
        if (queues.get(j).size() > 0) {
          Integer val = (Integer) queues.get(j).peek();
          if (val < target)
            return false;
        }
      }
      queues.get(d).poll();
    }

    return true;
  }
  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
    int k = 3;
    //        int[] nums = {3, 3, 2, 2, 1, 1};
    //        int k = 3;

    //        int[] nums = {1, 2, 3, 4};
    //        int k = 3;

    Q1585_check_if_string_is_transformable_with_substring_sort_operations solution = new Q1585_check_if_string_is_transformable_with_substring_sort_operations();
    String s = "84532", t = "34852";
    boolean res = solution.isTransformable(s, t);
    System.out.println(res);
  }
  }

