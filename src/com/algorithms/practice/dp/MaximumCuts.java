package com.algorithms.practice.dp;

public class MaximumCuts {

	// Given an integer N denoting the Length of a line segment. You need to cut the
	// line segment in such a way that the cut length of a line segment each time is
	// either x , y or z. Here x, y, and z are integers.

	// After performing all the cut operations, your total number of cut segments
	// must be maximum.

	// Return 0 if cuts are not possible.

	// simple recursive solution.
	public int maximizeCutSimple(int n, int x, int y, int z) {
		int maxValue = maximizeCutRec(n, x, y, z);
		return maxValue < 0 ? 0 : maxValue;
	}

	public int maximizeCutRec(int n, int x, int y, int z) {
		if (n == 0) {
			return 0;
		}

		if (n < 0) {
			return -1;
		}

		int xCount = maximizeCutRec(n - x, x, y, z);
		int yCount = maximizeCutRec(n - y, x, y, z);
		int zCount = maximizeCutRec(n - z, x, y, z);
		int maxCuts = Math.max(xCount, Math.max(yCount, zCount));
		if (maxCuts < 0) {
			return -1;
		}
		return 1 + maxCuts;
	}

	// memoization.
	public int maximizeCutsMemo(int n, int x, int y, int z) {
		Integer[] memo = new Integer[n + 1];
		maximizeCutsRec(n, x, y, z, memo);
		return memo[n] < 0 ? 0 : memo[n];
	}

	public int maximizeCutsRec(int n, int x, int y, int z, Integer[] memo) {
		if (n == 0) {
			memo[n] = 0;
		}

		if (n < 0) {
			return -1;
		}

		if (memo[n] == null) {
			int xCount = maximizeCutsRec(n - x, x, y, z, memo);
			int yCount = maximizeCutsRec(n - y, x, y, z, memo);
			int zCount = maximizeCutsRec(n - z, x, y, z, memo);
			int maxCuts = Math.max(xCount, Math.max(yCount, zCount));
			if (maxCuts < 0) {
				memo[n] = -1;
			} else {
				memo[n] = 1 + maxCuts;
			}
		}
		return memo[n];
	}

	// tabulation.
	public int maximizeCutsTabulation(int n, int x, int y, int z) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int xCut = (i - x < 0) ? -1 : dp[i - x];
			int yCut = (i - y < 0) ? -1 : dp[i - y];
			int zCut = (i - z < 0) ? -1 : dp[i - z];
			int maxCut = Math.max(xCut, Math.max(yCut, zCut));
			if (maxCut < 0) {
				dp[i] = -1;
			} else {
				dp[i] = 1 + maxCut;
			}
		}
		return dp[n] < 0 ? 0 : dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumCuts mc = new MaximumCuts();
		System.out.println("The maximum number of cuts possible are: " + mc.maximizeCutsTabulation(5, 2, 5, 1));
	}

}
