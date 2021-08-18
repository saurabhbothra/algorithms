package com.algorithms.practice.dp;

public class ZeroOneKnapsackProblem {

	// You are given weights and values of N items, put these items in a knapsack of
	// capacity W to get the maximum total value in the knapsack. Note that we have
	// only one quantity of each item.

	// In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which
	// represent values and weights associated with N items respectively. Also given
	// an integer W which represents knapsack capacity, find out the maximum value
	// subset of val[] such that sum of the weights of this subset is smaller than
	// or equal to W. You cannot break an item, either pick the complete item or
	// don’t pick it (0-1 property).

	// simple recursive solution.
	public int knapSackSimple(int W, int[] wt, int[] val, int n) {
		return knapSackRec(W, wt, val, wt.length - 1);
	}

	public int knapSackRec(int W, int[] wt, int[] val, int index) {
		if (W == 0 || index < 0) {
			return 0;
		}
		int currVal = 0;
		if (W >= wt[index]) {
			currVal = Math.max(currVal, val[index] + knapSackRec(W - wt[index], wt, val, index - 1));
		}
		return Math.max(currVal, knapSackRec(W, wt, val, index - 1));
	}

	// memoization.
	public int knapSackMemo(int W, int[] wt, int[] val, int n) {
		Integer[][] memo = new Integer[W + 1][n + 1];
		return knapSackRec(W, wt, val, wt.length, memo);
	}

	public int knapSackRec(int W, int[] wt, int[] val, int index, Integer[][] memo) {
		if (W == 0 || index == 0) {
			memo[W][index] = 0;
		}
		if (memo[W][index] == null) {
			int currVal = 0;
			if (W >= wt[index - 1]) {
				currVal = Math.max(currVal, val[index - 1] + knapSackRec(W - wt[index - 1], wt, val, index - 1, memo));
			}
			memo[W][index] = Math.max(currVal, knapSackRec(W, wt, val, index - 1, memo));
		}
		return memo[W][index];
	}

	// tabulation.
	public int knnapSackTabulation(int W, int[] wt, int[] val, int n) {
		int[][] dp = new int[W + 1][n + 1];
		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= wt[j - 1]) {
					int subResult = val[j - 1] + dp[i - wt[j - 1]][j - 1];
					dp[i][j] = Math.max(dp[i][j], subResult);
				}
			}
		}
		return dp[W][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeroOneKnapsackProblem zok = new ZeroOneKnapsackProblem();
		int[] values = { 10, 40, 30, 50 };
		int[] weight = { 5, 4, 6, 3 };
		System.out.println("The maximum total value is: " + zok.knapSackSimple(10, weight, values, 4));
		System.out.println("The maximum total value is: " + zok.knapSackMemo(10, weight, values, 4));
		System.out.println("The maximum total value is: " + zok.knnapSackTabulation(10, weight, values, 4));
	}

}
