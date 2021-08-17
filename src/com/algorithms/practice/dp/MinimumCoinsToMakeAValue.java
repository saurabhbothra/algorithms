package com.algorithms.practice.dp;

public class MinimumCoinsToMakeAValue {

	// You are given an integer array coins representing coins of different
	// denominations and an integer amount representing a total amount of money.

	// Return the fewest number of coins that you need to make up that amount. If
	// that amount of money cannot be made up by any combination of the coins,
	// return -1.

	// You may assume that you have an infinite number of each kind of coin.

	// simple recursive solution one.
	public int coinChangeSimple(int[] coins, int amount) {
		return coinChangeRec(coins, amount, 0);
	}

	public int coinChangeRec(int[] coins, int amount, int index) {
		if (amount == 0) {
			return 0;
		}
		if (index == coins.length) {
			return -1;
		}
		int excludeCoinCount = coinChangeRec(coins, amount, index + 1);
		int includeCoinCount = -1;
		if (amount >= coins[index]) {
			includeCoinCount = coinChangeRec(coins, amount - coins[index], index);
		}
		if (includeCoinCount >= 0) {
			includeCoinCount += 1;
		}
		if (includeCoinCount < 0) {
			return excludeCoinCount;
		} else if (excludeCoinCount < 0) {
			return includeCoinCount;
		}
		return Math.min(excludeCoinCount, includeCoinCount);
	}

	// simple recursive solution two.
	public int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		int res = -1;
		for (int i = 0; i < coins.length; i++) {
			if (amount >= coins[i]) {
				int subResult = coinChange(coins, amount - coins[i]);
				if (subResult != -1) {
					res = (res == -1) ? 1 + subResult : Math.min(res, 1 + subResult);
				}
			}
		}

		return res;
	}

	// memoization.
	public int coinChangeMemo(int[] coins, int amount) {
		Integer[][] memo = new Integer[amount + 1][coins.length + 1];
		return coinChangeRec(coins, amount, 0, memo);
	}

	public int coinChangeRec(int[] coins, int amount, int index, Integer[][] memo) {
		if (amount == 0) {
			memo[amount][index] = 0;
		}
		if (index == coins.length) {
			memo[amount][index] = -1;
		}
		if (memo[amount][index] == null) {
			int excludeCoinCount = coinChangeRec(coins, amount, index + 1, memo);
			int includeCoinCount = -1;
			if (amount >= coins[index]) {
				includeCoinCount = coinChangeRec(coins, amount - coins[index], index, memo);
			}
			if (includeCoinCount >= 0) {
				includeCoinCount += 1;
			}
			if (includeCoinCount < 0) {
				memo[amount][index] = excludeCoinCount;
			} else if (excludeCoinCount < 0) {
				memo[amount][index] = includeCoinCount;
			} else {
				memo[amount][index] = Math.min(excludeCoinCount, includeCoinCount);
			}
		}
		return memo[amount][index];
	}

	// memoization two.
	public int coinChangeMemoTwo(int[] coins, int amount) {
		Integer[] memo = new Integer[amount + 1];
		return coinChangeMemoRec(coins, amount, memo);
	}

	public int coinChangeMemoRec(int[] coins, int amount, Integer[] memo) {
		if (amount == 0) {
			memo[amount] = 0;
		}
		if (memo[amount] == null) {
			int res = -1;
			for (int i = 0; i < coins.length; i++) {
				if (amount >= coins[i]) {
					int subResult = coinChangeMemoRec(coins, amount - coins[i], memo);
					if (subResult != -1) {
						res = (res == -1) ? 1 + subResult : Math.min(res, 1 + subResult);
					}
				}
			}

			memo[amount] = res;
		}
		return memo[amount];
	}

	// tabulation.
	public int coinChangeTabulation(int[] coins, int amount) {
		int[][] dp = new int[amount + 1][coins.length + 1];
		for (int i = 0; i <= amount; i++) {
			dp[i][coins.length] = -1;
		}
		for (int i = 0; i <= coins.length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= amount; i++) {
			for (int j = coins.length - 1; j >= 0; j--) {
				int excludeCount = dp[i][j + 1];
				int includeCount = -1;
				if (i >= coins[j]) {
					includeCount = dp[i - coins[j]][j];
				}
				if (includeCount >= 0) {
					includeCount++;
				}
				if (excludeCount == -1) {
					dp[i][j] = includeCount;
				} else if (includeCount == -1) {
					dp[i][j] = excludeCount;
				} else {
					dp[i][j] = Math.min(includeCount, excludeCount);
				}
			}
		}
		return dp[amount][0];
	}

	// tabulation two.
	public int coinChangeTabulationTwo(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			int res = -1;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					int subResult = dp[i - coins[j]];
					if (subResult != -1) {
						res = (res == -1) ? 1 + subResult : Math.min(res, 1 + subResult);
					}
				}
			}
			dp[i] = res;
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCoinsToMakeAValue mc = new MinimumCoinsToMakeAValue();
		int[] coins = { 1, 2, 5 };
		System.out.println("The minimum number of coins required are: " + mc.coinChange(coins, 11));
		System.out.println("The minimum number of coins required are: " + mc.coinChangeMemoTwo(coins, 11));
		System.out.println("The minimum number of coins required are: " + mc.coinChangeTabulationTwo(coins, 11));
	}

}
