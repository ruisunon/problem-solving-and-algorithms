package io.leetcode.q1400;

import io.leetcode.q1500.Q1590_make_sum_divisible_by_p;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1438_Longest_continuous_subarray_with_absolute_diff_lessThanOrEqualTo_limit {
    public int longestSubarray(int[] nums, int limit) {
      ArrayDeque<Integer> maxQ=new ArrayDeque<>();
      ArrayDeque<Integer> minQ=new ArrayDeque<>();
      int left=0, ans=1;
      for(int m=0; m<nums.length; m++){
        while(!maxQ.isEmpty() && maxQ.peekLast()<nums[m])
          maxQ.pollLast();
        while(!minQ.isEmpty() && minQ.peekLast()>nums[m])
          minQ.pollLast();
        maxQ.addLast(nums[m]);
        minQ.addLast(nums[m]);

        while(maxQ.peekFirst()-minQ.peekFirst()>limit){
          if(maxQ.peekFirst()==nums[left]) maxQ.pollFirst();
          if(minQ.peekFirst() ==nums[left]) minQ.pollFirst();
          left++;
        }
        ans=Math.max(ans, m-left+1);
      }
      return ans;
  }
  public int longestSubarray1(int[] nums, int limit) {
    int start=0;
    int end=0, res=1;
    PriorityQueue<Integer> minQ=new PriorityQueue<>();
    PriorityQueue<Integer> maxQ= new PriorityQueue<>(Comparator.reverseOrder());
    while(start<=end && end<nums.length){
      minQ.add(nums[end]);
      maxQ.add(nums[end]);
      int min=minQ.peek();
      int max=maxQ.peek();
      if(Math.abs(max-min)<=limit){
        end++;
        res=Math.max(res, end-start);
      }else {
        minQ.remove(nums[start]);
        maxQ.remove(nums[start]);
        end++;
        start++;
      }
    }
    return res;

  }
  public static void main(String[] args) {
    int[] nums = {3,7,4,2, 3, 5, 9};
    int  p = 6;
    Q1438_Longest_continuous_subarray_with_absolute_diff_lessThanOrEqualTo_limit solution = new Q1438_Longest_continuous_subarray_with_absolute_diff_lessThanOrEqualTo_limit();
    String s = "84532", t = "34852";
    int res = solution.longestSubarray(nums, p);
    System.out.println(res);
  }
}
