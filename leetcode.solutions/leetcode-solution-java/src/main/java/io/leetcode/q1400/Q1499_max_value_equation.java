package io.leetcode.q1400;
//思路
//
//    这道题可以抽象为一个区间最值问题。只不过，这里的区间是通过points[j][0] - points[i][0] <= k指定的动态区间。求区间最值问题，
//    用单调队列，单调队列在每次循环遍历中做如下3步：Monotonic Queue
//
//    1. 如果队首元素不在区间内（根据队首元素和当前元素判断），则队首元素出队；
//    2. 用更新后的队首元素和当前元素做计算，维护区间最值；
//    3. 从队尾开始向前，比当前元素大/小（单调递减/递增队列）的出队，然后当前元素入队。
//
//    从上面的步骤可以看出，单调队列需要队首出队、队尾出队、队尾入队操作，因此需要一个双端队列，Java中可以使用ArrayDeque.
//    由于序列中每个元素至多入队一次，出队一次，因此单调队列解法的时间复杂度是O(n)，其中n为序列长度。

import java.util.ArrayDeque;

//A monotonic Queue is a data structure the elements from the front to the end is strictly either increasing or
//  decreasing. For example, there is an line at the hair salon, and you would naturally start from the end of the
//  line. However, if you are allowed to kick out any person that you can win at a fight, if every one follows the
//  rule, then the line would start with the most powerful man and end up with the weakest one. This is an example of
//  monotonic decreasing queue. We have either increasing or decreasing queue.
//    Monotonic increasing queue: to push an element e, starts from the rear element, we pop out element s≥e(violation);
//    Monotonic decreasing queue: we pop out element s<=e (violation).
//    Sometimes, we can relax the strict monotonic condition, and can allow the stack or queue have repeat value.
public class Q1499_max_value_equation {

  public int findMaxValueOfEquation(int[][] points, int k) {
    int i = 0, n = points.length, ret = Integer.MIN_VALUE;
    ArrayDeque<Node> dq = new ArrayDeque<>();
    dq.add(new Node(points[0][0], points[0][1]));
    for (i=1; i<n; ++i) {
      while (!dq.isEmpty() && points[i][0] - dq.getFirst().x > k) {
        dq.removeFirst();
      }
      if (!dq.isEmpty()) {
        ret = Math.max(ret, dq.getFirst().diff() + points[i][0] + points[i][1]);
      }
      int curDiff = points[i][1] - points[i][0];
      while (!dq.isEmpty() && dq.getLast().diff() <= curDiff) {
        dq.removeLast();
      }
      dq.add(new Node(points[i][0], points[i][1]));
    }
    return ret;
  }
}
class Node {
  public int x, y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int diff() {
    return y - x;
  }
}