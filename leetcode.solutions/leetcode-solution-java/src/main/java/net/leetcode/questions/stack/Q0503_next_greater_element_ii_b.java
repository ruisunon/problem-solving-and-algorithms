package net.leetcode.questions.stack;

import java.util.Arrays;
import java.util.Stack;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence3;

/**
 * @author liweiwei1419
 * @date 2019/12/3 5:07 下午
 */
public class Q0503_next_greater_element_ii_b {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        // 初始化为 -1 的原因：在遍历终止的时候，栈中还存在的那些元素表示它们的右边没有比它大的元素
        int[] res = new int[len];
        Arrays.fill(res, -1);

        // 存的应该是索引
        // 如果新来的数小于等于栈顶，就添加，如果严格大于，就弹栈
        Stack<Integer> stack = new Stack<>();

        int len2 = len << 1;
        for (int i = 0; i < len2; i++) {

            // 不能直接对 i 取模，否则会影响遍历，进入死循环
            int j = i % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                int index = stack.pop();
                res[index] = nums[j];
            }

            // 超出 len 的那部分，是虚拟的，因此没有比较计算结果
            // 遍历第 2 遍，是为了让栈弹出为空
            if (i < len) {
                stack.push(i);
            }
            // 栈中元素为空的时候，后面的元素就没有必要看了
            if (stack.isEmpty()) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Q0128_longest_consecutive_sequence3 solution3 = new Q0128_longest_consecutive_sequence3();
        int[] res = solution3.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
