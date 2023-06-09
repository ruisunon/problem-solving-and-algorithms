package io.leetcode.q250;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and
 * is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or
 * deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an
 * empty queue).
 */
public class Q232_ImplementQueueUsingStacks {

    private static class MyQueue {

        private Deque<Integer> inStack = new ArrayDeque<>();

        private Deque<Integer> outStack = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            move();
            return outStack.pop();
        }

        private void move() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            move();
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    @Test
    public void testMethod() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        Assert.assertEquals(1, queue.peek());
        Assert.assertEquals(1, queue.pop());
        Assert.assertFalse(queue.empty());
    }

}
