package net.leetcode.questions.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Nested 表示"嵌套的"
 */
public class Q0341_flatten_nested_list_iterator1 implements Iterator<Integer> {

    // 使用 [[1,1],2,[1,1]] 这个例子去想，可以使用栈来完成，并且入栈的时候，应该倒着放进去


    private Deque<NestedInteger> stack = new ArrayDeque<>();
    private Integer data;

    public Q0341_flatten_nested_list_iterator1(List<NestedInteger> nestedList) {
        int len = nestedList.size();
        // 把嵌套的整形全部放到栈中
        // 注意：要倒着放！
        for (int i = len - 1; i >= 0; i--) {
            stack.addLast(nestedList.get(i));
        }
    }

    /**
     * 要求我们实现的方法 1
     *
     * @return
     */
    @Override
    public Integer next() {
        return data;
    }

    /**
     * 要求我们实现的方法 2
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            // 栈顶元素
            NestedInteger top = stack.removeLast();
            if (top.isInteger()) {
                data = top.getInteger();
                return true;
            } else {
                List<NestedInteger> list = top.getList();
                int len = list.size();
                // 注意：要倒着放！
                for (int i = len - 1; i >= 0; i--) {
                    stack.addLast(list.get(i));
                }
            }
        }
        return false;
    }
}
