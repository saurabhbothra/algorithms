package com.algorithms.practice.dp;

public class CoinChangeCountCombinations {

	// You are given an integer array coins representing coins of different
	// denominations and an integer amount representing a total amount of money.

	// Return the number of combinations that make up that amount. If that amount of
	// money cannot be made up by any combination of the coins, return 0.

	// You may assume that you have an infinite number of each kind of coin.

	// The answer is guaranteed to fit into a signed 32-bit integer.

	// 1 <= coins.length <= 300
	// 1 <= coins[i] <= 5000
	// All the values of coins are unique.
	// 0 <= amount <= 5000

	// simple recursive solution.
	public int changeSimple(int amount, int[] coins) {
		return changeRec(amount, coins, 0);
	}

	public int changeRec(int amount, int[] coins, int index) {
		if (amount == 0) {
			return 1;
		} else if (index == coins.length) {
			return 0;
		}
		int res = changeRec(amount, coins, index + 1);
		if (coins[index] <= amount) {
			res = res + changeRec(amount - coins[index], coins, index);
		}
		return res;
	}

	// memoization.
	public int changeMemo(int amount, int[] coins) {
		Integer[][] memo = new Integer[amount + 1][coins.length + 1];
		return changeRec(amount, coins, 0, memo);
	}

	public int changeRec(int amount, int[] coins, int index, Integer[][] memo) {
		if (amount == 0) {
			memo[amount][index] = 1;
		} else if (index == coins.length) {
			memo[amount][index] = 0;
		}
		if (memo[amount][index] == null) {
			int res = changeRec(amount, coins, index + 1, memo);
			if (coins[index] <= amount) {
				res = res + changeRec(amount - coins[index], coins, index, memo);
			}
			memo[amount][index] = res;
		}
		return memo[amount][index];
	}

	// tabulation.
	public static int changeTabulation(int amount, int[] coins) {
		int[][] dp = new int[amount + 1][coins.length + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = dp[i].length - 2; j >= 0; j--) {
				if (i >= coins[j]) {
					dp[i][j] = dp[i][j + 1] + dp[i - coins[j]][j];
				} else {
					dp[i][j] = dp[i][j + 1];
				}
			}
		}
		return dp[amount][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChangeCountCombinations cc = new CoinChangeCountCombinations();
		int[] coins = { 1, 2, 5 };
		System.out.println("The total number of ways are: " + cc.changeMemo(5, coins));
	}

}
