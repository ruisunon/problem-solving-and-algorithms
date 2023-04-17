package net.leetcode.questions.dynamic_programming;// 考虑两个数组 up[] 和 down[]
// 从第 2 个元素开始（即索引为 1 开始）比较它与前一个元素的值
// 如果它大于前一个元素，就根据 down 数组的最后一个值更新 up   数组的值
// 如果它小于前一个元素，就根据 up   数组的最后一个值更新 down 数组的值
// 如果它等于前一个元素，两个数组的值都不更新
// 我们把表格写一写

import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class wiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 定义：从第 2 个元素开始，当前元素比上一个元素大的时候，能够构成的最长摇摆子序列的长度，否则，该值与之前的值相等
        int[] up = new int[len];
        // 定义：从第 2 个元素开始，当前元素比上一个元素小的时候，能够构成的最长摇摆子序列的长度，否则，该值与之前的值相等
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        // 【关键】抓住一点：增加之后，再增加，最长摇摆子序列的长度不变，只有减少了最长摇摆子序列的长度才会加 1
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                // 上升：表示当前这个元素可以接在 down 所表示的最长摇摆子序列的最后一个，构成一个更长的子序列
                // 此时更新 up 的值，它根据 down 的最后一个 + 1
                // 理解这一步很关键，这一步理解清楚了，后面的两个分支就自然清楚了
                up[i] = down[i - 1] + 1;
                // 不变，也要把值复制过来
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                // 减少
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else { // nums[i] = nums[i - 1]
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        // System.out.println(Arrays.toString(up));
        // System.out.println(Arrays.toString(down));
        return Math.max(up[len - 1], down[len - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        wiggleMaxLength solution2 = new wiggleMaxLength();
        int wiggleMaxLength = solution2.wiggleMaxLength(nums);
        System.out.println(wiggleMaxLength);
    }

    public static class wiggleMaxLength2 {

        // 动态规划
        // 思路：结尾的那个数字很重要
        // 注意：摆动序列的最长子序列的长度

        // dp[i][0] 表示以 i 结尾的数字是严格上升的
        // dp[i][1] 表示以 i 结尾的数字是严格下降的

        // 状态转移方程：只看结尾和前一个数的关系
        // 初始化：dp[0][0] = 1，dp[0][1] = 1

        // 这是比较容易想到的
        // dp[i][0] = dp[i - 1][1] + 1, if nums[i] - nums[i - 1] > 0
        // dp[i][1] = dp[i - 1][0] + 1, if nums[i] - nums[i - 1] < 0

        // 分析到这里，知道需要分类讨论

        // 输出：拉通看最大值

        public int wiggleMaxLength(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return len;
            }

            int[][] dp = new int[len][2];
            dp[0][0] = 1;
            dp[0][1] = 1;

            for (int i = 1; i < len; i++) {
                if (nums[i - 1] < nums[i]) {
                    // 结尾时候的状态是严格上升的
                    dp[i][0] = dp[i - 1][1] + 1;
                    dp[i][1] = dp[i - 1][1];

                } else if (nums[i - 1] > nums[i]) {
                    // 结尾时候的状态是严格下降的
                    dp[i][1] = dp[i - 1][0] + 1;
                    dp[i][0] = dp[i - 1][0];

                } else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1];
                }
            }
            return Math.max(dp[len - 1][0], dp[len - 1][1]);
        }

        public static void main(String[] args) {
            // int[] nums = {1, 7, 4, 9, 2, 5};
            int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
            wiggleMaxLength2 solution2 = new wiggleMaxLength2();
            int res = solution2.wiggleMaxLength(nums);
            System.out.println(res);
        }
    }
}
