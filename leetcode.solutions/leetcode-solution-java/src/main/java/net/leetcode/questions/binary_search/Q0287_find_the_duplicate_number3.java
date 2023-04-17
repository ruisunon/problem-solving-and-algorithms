package net.leetcode.questions.binary_search;

public class Q0287_find_the_duplicate_number3 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        // 注意这里的边界
        int right = len - 1;

        while (left < right) {
            int mid = (left + right + 1) >>> 1;

            int count = 0;
            for (int num : nums) {
                if (num < mid) {
                    count++;
                }
            }
            // 容易出错，需要仔细分析
            if (count < mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
