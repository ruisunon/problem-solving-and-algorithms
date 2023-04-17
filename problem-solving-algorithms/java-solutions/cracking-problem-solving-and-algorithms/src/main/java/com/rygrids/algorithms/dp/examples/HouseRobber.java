/**
 * Problem: https://leetcode.com/problems/house-robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 *  the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 *  and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *            Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

package com.rygrids.algorithms.dp.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HouseRobber {

	int[] dp;
	int[] dp1;

	public int rob(int[] houses) {
		int n = houses.length;
		dp = new int[n + 2];
		dp1 = new int[n + 2];
		IntStream.rangeClosed(0, n-1).forEach(i -> {dp1[i+2] = Math.max(dp1[i + 1], dp1[i] + houses[i]);
		System.out.println(dp1[i+2]);
		});
//		for (int i = 0, j = 2; i < n; i++, j++) {
//			dp[j] = Math.max(dp[j - 1], dp[j - 2] + houses[i]);
//			System.out.println(dp[j]);
//		}
		return dp1[n + 1];
	}

	// Finds a set of optimal houses to rob. This method assumes
	// the rob method was already called and 'dp' is populated.
	public List<Integer> findRobbedHouses(int[] houses) {
		int n = houses.length;
		List<Integer> robbedHouses = new ArrayList<>();
		for (int i = n - 1, j = n + 1; i >= 0; i--, j--) {
			if (dp[j - 2] + houses[i] > dp[j - 1]) {
				robbedHouses.add(i);
			}
		}
		return robbedHouses;
	}

	public static void main(String[] args) {
		HouseRobber robber = new HouseRobber();
		int[] houses = { 5, 2, 4, 7, 2, 13, 9, 1, 8, 4 };
		int amount = robber.rob(houses);
		System.out.println("Robbed: " + amount + "$");

		List<Integer> robbedHouses = robber.findRobbedHouses(houses);
		int sum = 0;
		for (int houseIndex : robbedHouses) {
			System.out.printf("Robbed house at index %d, for %d$\n", houseIndex, houses[houseIndex]);
			sum += houses[houseIndex];
		}

		if (amount != sum) {
			System.out.println("Oh dear, something is very wrong.");
		}
	}
}