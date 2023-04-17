package net.leetcode.questions.array;

// Design a Leaderboard class, which has 3 functions:
//
//    addScore(playerId, score): Update the leaderboard by adding score to the given player's score.
//    If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
//    top(K): Return the score sum of the top K players.
//    reset(playerId): Reset the score of the player with the given id to 0. It is guaranteed that the player
//    was added to the leaderboard before calling this function.
//    Initially, the leaderboard is empty.
//
//    Example 1:
//
//    Input:
//    ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
//    [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
//    Output:
//    [null,null,null,null,null,null,73,null,null,null,141]
//
//    Explanation:
//    Leaderboard leaderboard = new Leaderboard ();
//    leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//    leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//    leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//    leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//    leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//    leaderboard.top(1);           // returns 73;
//    leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//    leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//    leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//    leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
//    Constraints:
//
//    1 <= playerId, K <= 10000
//    It's guaranteed that K is less than or equal to the current number of players.
//    1 <= score <= 100
//    There will be at most 1000 function calls.
public class Q1244_design_a_leaderboard {

    // 树状数组不行，题目要求的是排名，这一版代码保留，请忽略


    /**
     * 预处理数组
     */
    private int[] tree;

    /**
     * 在 i 之前有多少元素被重置了
     */
    private int[] board;
    private int len = 10000;

    private int endId = 0;

    public Q1244_design_a_leaderboard() {
        tree = new int[len + 1];
        board = new int[len + 1];
    }

    public void addScore(int playerId, int score) {
        update(playerId, score, tree);
        update(playerId, 1, board);
    }

    public int top(int K) {
        // 在榜单上的人数
        int onLeaderboard = query(K , board);

        // 加上不在榜单上的人数
        int a = K - onLeaderboard;
        System.out.println("空缺人数 => " + a);
        K += a;
        return query(K,tree);
    }

    // 1 1 1 1 1 表示有成绩，0 表示没有成绩

    public void reset(int playerId) {
        int score = query(playerId, tree) - query(playerId - 1, tree);
        update(playerId, -score, tree);
        update(playerId, -1, board);
    }

    /**
     * 查询前缀和
     *
     * @param i 前缀的最大索引，即查询区间 [0, i] 的所有元素之和
     */
    private int query(int i, int[] nums) {
        // 从右到左查询
        int sum = 0;
        while (i > 0) {
            sum += nums[i];
            i -= lowbit(i);
        }
        return sum;
    }

    /**
     * 单点更新
     *
     * @param i     原始数组索引 i
     * @param delta 变化值 = 更新以后的值 - 原始值
     */
    private void update(int i, int delta, int[] nums) {
        // 从下到上更新，注意，预处理数组，比原始数组的 len 大 1，故 预处理索引的最大值为 len
        while (i <= len) {
            nums[i] += delta;
            i += lowbit(i);
        }
    }


    public static int lowbit(int x) {
        return x & (-x);
    }


    public static void main(String[] args) {
        Q1244_design_a_leaderboard leaderboard = new Q1244_design_a_leaderboard();
        leaderboard.addScore(1, 78);
        leaderboard.addScore(2, 60);
        leaderboard.addScore(3, 84);
        leaderboard.addScore(4, 7);
        leaderboard.addScore(5, 61);


        System.out.println(leaderboard.top(1));
    }
}
