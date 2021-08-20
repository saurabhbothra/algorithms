package com.algorithms.practice.dp;

public class CountBSTsWithNKeys {

	// Given an integer n, return the number of structurally unique BST's (binary
	// search trees) which has exactly n nodes of unique values from 1 to n.

	// 1 <= n <= 19.

	// simple recursive solution.
	public int numTreesSimple(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		int uniqueWays = 0;
		for (int i = n; i >= 1; i--) {
			int leftCount = numTreesSimple(i - 1);
			int rightCount = numTreesSimple(n - i);
			uniqueWays += leftCount * rightCount;
		}
		return uniqueWays;
	}

	// memoization.
	public int numTreesMemo(int n) {
		Integer[] memo = new Integer[n + 1];
		return numTreesRec(n, memo);
	}

	public int numTreesRec(int n, Integer[] memo) {
		if (n == 1 || n == 0) {
			memo[n] = 1;
		}
		if (memo[n] == null) {
			int uniqueWays = 0;
			for (int i = n; i >= 1; i--) {
				int leftCount = numTreesRec(i - 1, memo);
				int rightCount = numTreesRec(n - i, memo);
				uniqueWays += leftCount * rightCount;
			}
			memo[n] = uniqueWays;
		}
		return memo[n];
	}

	// tabulation.
	public int numTreesTabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int uniqueWays = 0;
			for (int j = i; j >= 1; j--) {
				uniqueWays += (dp[j - 1] * dp[i - j]);
			}
			dp[i] = uniqueWays;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountBSTsWithNKeys bst = new CountBSTsWithNKeys();
		System.out.println("The number of unique bst's can be: " + bst.numTreesSimple(3));
		System.out.println("The number of unique bst's can be: " + bst.numTreesMemo(3));
		System.out.println("The number of unique bst's can be: " + bst.numTreesTabulation(3));
	}

}
