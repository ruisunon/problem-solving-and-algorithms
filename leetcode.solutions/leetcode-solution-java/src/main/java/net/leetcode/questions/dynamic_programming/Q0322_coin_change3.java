package net.leetcode.questions.dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import net.leetcode.questions.disjoint_set.Q0128_longest_consecutive_sequence4;

public class Q0322_coin_change3 {

    // 广度优先遍历的写法

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        visited[amount] = true;
        queue.offer(amount);

        // 排序是为了加快广度优先遍历过程中，对硬币面值的遍历，起到剪枝的效果
        Arrays.sort(coins);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer head = queue.poll();
                for (int coin : coins) {
                    int next = head - coin;
                    // 只要遇到 0，就找到了一个最短路径
                    if (next == 0) {
                        return step;
                    }

                    if (next < 0) {
                        // 由于 coins 升序排序，后面的面值会越来越大，剪枝
                        break;
                    }

                    if (!visited[next]) {
                        queue.offer(next);
                        // 添加到队列的时候，就应该立即设置为 true
                        // 否则还会发生重复访问
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        // 进入队列的顶点都出队，都没有看到 0 ，就表示凑不出硬币
        return -1;
    }

    public static void main(String[] args) {
        Q0128_longest_consecutive_sequence4 solution4 = new Q0128_longest_consecutive_sequence4();
        // int[] coins = {1, 2, 5};
        // int amount = 11;
        int[] coins = {1};
        int amount = 0;

        int res = solution4.coinChange(coins, amount);
        System.out.println(res);
    }
}
