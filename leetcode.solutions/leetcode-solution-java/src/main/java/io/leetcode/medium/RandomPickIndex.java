package io.leetcode.medium;

class Solution {
  int[] nums;
  Random rand;
  public Solution(int[] nums) {
    this.nums = nums;
    rand = new Random();
  }

  public int pick(int target) {
    int count = 0;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (rand.nextInt(++count) == 0) {
          res = i;
        }
      }
    }
    return res;
  }
}

/**
 * Your Q0169_majority_element object will be instantiated and called as such:
 * Q0169_majority_element obj = new Q0169_majority_element(nums);
 * int param_1 = obj.pick(target);
 */
