package net.leetcode.questions.hash_table;

import java.util.HashMap;
import java.util.Map;
import net.leetcode.questions.array.Q0027_remove_element;

// 参考资料
    // https://www.jianshu.com/p/6bdb4b6cd1a1
    // https://blog.csdn.net/sscssz/article/details/53074351

public class Q0447_number_of_boomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                int distance = distance(points[i], points[j]);
                if (!map.containsKey(distance)) {
                    // 这一步不太好理解
                    map.put(distance, 0);
                }
                // 这一步不太好理解
                Integer num = map.get(distance);
                res += num * 2;
                map.put(distance, num + 1);
            }
        }
        return res;
    }

    private int distance(int[] point1, int[] point2) {
        int diffX = point1[0] - point2[0];
        int diffY = point1[1] - point2[1];
        return diffX * diffX + diffY * diffY;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        Q0027_remove_element solution = new Q0027_remove_element();
        int numberOfBoomerangs = solution.numberOfBoomerangs(points);
        System.out.println(numberOfBoomerangs);
    }
}
