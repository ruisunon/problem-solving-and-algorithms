package io.leetcode.q050;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.runner.RunWith;
import io.leetcode.q450.Q407_TrappingRainWaterII;
import util.runner.Answer;
import util.runner.LeetCodeRunner;
import util.runner.TestData;
import util.runner.data.DataExpectation;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it is able to trap after raining.
 *
 * (图见 Q042_PIC.png)
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * 下一题: {@link Q407_TrappingRainWaterII}
 */
@RunWith(LeetCodeRunner.class)
public class Q042_TrappingRainWater {

    /**
     * 我的一个比较丑陋的实现. 如果是下坡, 说明前面有蓄水池, 算出这个蓄水池至少有多少
     * 然后向里面填充对应数量 (避免重复计算), 下坡同理.
     */
    @Answer
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (i < height.length - 1 && height[i] > height[i + 1]) {
                int fillSpace = height[i] - height[i + 1];
                int j = i + 2;
                while (j < height.length && height[j] < height[i]) {
                    fillSpace = Math.min(fillSpace, height[i] - height[j]);
                    j++;
                }
                if (j < height.length) {
                    res += fillSpace * (--j - i);
                    while (j > i) {
                        height[j--] += fillSpace;
                    }
                }
            }
            if (i > 0 && height[i - 1] < height[i]) {
                int fillSpace = height[i] - height[i - 1];
                int j = i - 2;
                while (j >= 0 && height[j] < height[i]) {
                    fillSpace = Math.min(fillSpace, height[i] - height[j]);
                    j--;
                }
                if (j >= 0) {
                    res += fillSpace * (i - ++j);
                    while (j < i) {
                        height[j++] += fillSpace;
                    }
                }
            }
        }
        return res;
    }

    /**
     * LeetCode 上一种从左右投影的方式.
     * 左边的最高点, 确保比右边的最高点小, 这样, 就一定会形成一个以左边最高点为水位的水池(水池宽度可能为0),
     * 如果遇到了比它高的点, 则这个点变为最高点. 如果遇到了比它低的点, 则这个点的水位就是最高点代表的水位减去当前点的底.
     * 对右边最高点同理.
     */
    @Answer
    public int leftRight(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }

    // 单调递增栈的实现方式. 当遇到比栈顶高度大的时候, 就说明有可能会有坑存在, 可以装雨水.
    @Answer
    public int trap3(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length;) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
                i++;
            } else {
                // 形成水坑, 此时 height[i] 是右边的坡, stack 栈顶元素是底, stack 栈顶第2 个元素是左边的坡
                int j = stack.pop();
                if (!stack.isEmpty()) {
                    res += (Math.min(height[i], height[stack.peek()]) - height[j]) * (i - stack.peek() - 1);
                }
                // 栈顶出坑后, 可能新的栈顶也是底, 所以这里i 不自增.
            }
        }
        return res;
    }

    @TestData
    public DataExpectation example = DataExpectation.builder()
            .addArgument(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})
            .expect(6)
            .build();

    @TestData
    public DataExpectation border1 = DataExpectation.builder()
            .addArgument(new int[]{0})
            .expect(0)
            .build();

    @TestData
    public DataExpectation border2 = DataExpectation.builder()
            .addArgument(new int[]{0, 1, 0})
            .expect(0)
            .build();

    @TestData
    public DataExpectation normal1 = DataExpectation.builder()
            .addArgument(new int[]{1, 0, 2})
            .expect(1)
            .build();

    @TestData
    public DataExpectation normal2 = DataExpectation.builder()
            .addArgument(new int[]{4, 2, 3})
            .expect(1)
            .build();
}
