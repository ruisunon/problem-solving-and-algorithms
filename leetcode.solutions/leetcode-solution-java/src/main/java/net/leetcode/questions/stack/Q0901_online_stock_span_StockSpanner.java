package net.leetcode.questions.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q0901_online_stock_span_StockSpanner {

    private List<Integer> stock;

    /**
     * Java 官方推荐使用 Deque，只用和栈相关的接口
     */
    private Deque<Integer> indexes;

    private int index;

    public Q0901_online_stock_span_StockSpanner() {
        // 哨兵，这个元素永远不回出栈
        stock = new ArrayList<>();
        stock.add(10_0000 + 1);

        indexes = new ArrayDeque<>();
        indexes.addLast(0);
        index = 0;
    }

    public int next(int price) {
        index++;

        // 特别注意：不要用 indexes.peek()，这个方法等价于 peekFirst()
        while (!indexes.isEmpty() && stock.get(indexes.peekLast()) <= price) {
            indexes.removeLast();
        }

        // 因为 indexes 后面会更改，因此这里先把结果暂存一下
        int res =  index - indexes.peekLast() ;

        stock.add(price);
        indexes.addLast(index);

        return res;
    }

    public static void main(String[] args) {
        Q0901_online_stock_span_StockSpanner stockSpanner = new Q0901_online_stock_span_StockSpanner();
        int next = stockSpanner.next(100);
        System.out.println(next);

        int next2 = stockSpanner.next(80);
        System.out.println(next2);

        int next3 = stockSpanner.next(60);
        System.out.println(next3);

        int next4 = stockSpanner.next(70);
        System.out.println(next4);

        int next5 = stockSpanner.next(60);
        System.out.println(next5);

        int next6 = stockSpanner.next(75);
        System.out.println(next6);

        int next7 = stockSpanner.next(85);
        System.out.println(next7);
    }
}
