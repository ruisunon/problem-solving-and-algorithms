package net.leetcode.questions.hash_table;

import java.util.HashMap;
import java.util.Map;
import net.leetcode.questions.array.Q0026_remove_duplicates_from_sorted_array2;

public class Q0447_number_of_boomerangs1 {

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int distance = distance(points[i], points[j]);
                if (!map.containsKey(distance)) {
                    map.put(distance, 1);
                } else {
                    map.put(distance, map.get(distance) + 1);
                }

            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if(value>1){
                    res += value * (value - 1);
                }
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
        Q0026_remove_duplicates_from_sorted_array2 solution2 = new Q0026_remove_duplicates_from_sorted_array2();
        int numberOfBoomerangs = solution2.numberOfBoomerangs(points);
        System.out.println(numberOfBoomerangs);
    }
}
