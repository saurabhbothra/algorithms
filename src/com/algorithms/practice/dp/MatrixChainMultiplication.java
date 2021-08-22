package com.algorithms.practice.dp;

public class MatrixChainMultiplication {

	// Given an array of size n and it has n - 1 matrices. We need to find out
	// minimum number of element multiplications required to multiply all these
	// matrices together.

	// simple recursive solution.
	public int mcmSimple(int[] nums) {
		return mcmRec(nums, 0, nums.length - 1);
	}

	public int mcmRec(int[] nums, int i, int j) {
		if (i == j - 1) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		for (int k = i + 1; k < j; k++) {
			int fTerm = mcmRec(nums, i, k);
			int sTerm = mcmRec(nums, k, j);
			int tTerm = nums[i] * nums[k] * nums[j];
			res = Math.min(res, (fTerm + sTerm + tTerm));
		}
		return res;
	}

	// memoization.
	public int mcmMemo(int[] nums) {
		Integer[][] memo = new Integer[nums.length][nums.length];
		return mcmRec(nums, 0, nums.length - 1, memo);
	}

	public int mcmRec(int[] nums, int i, int j, Integer[][] memo) {
		if (i == j - 1) {
			memo[i][j] = 0;
		}
		if (memo[i][j] == null) {
			int res = Integer.MAX_VALUE;
			for (int k = i + 1; k < j; k++) {
				int fTerm = mcmRec(nums, i, k, memo);
				int sTerm = mcmRec(nums, k, j, memo);
				int tTerm = nums[i] * nums[k] * nums[j];
				res = Math.min(res, (fTerm + sTerm + tTerm));
			}
			memo[i][j] = res;
		}
		return memo[i][j];
	}

	// tabulation.
	public int mcmTabulation(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				if (i == j - 1) {
					dp[i][j] = 0;
				} else {
					int res = Integer.MAX_VALUE;
					for (int k = i + 1; k < j; k++) {
						int fTerm = dp[i][k];
						int sTerm = dp[k][j];
						int tTerm = nums[i] * nums[k] * nums[j];
						res = Math.min(res, (fTerm + sTerm + tTerm));
					}
					dp[i][j] = res;
				}
			}
		}
		return dp[0][nums.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixChainMultiplication mcm = new MatrixChainMultiplication();
		int[] nums = { 40, 20, 30, 10, 30 };
		System.out.println("The minimum number of mkultiplications required are: " + mcm.mcmSimple(nums));
		System.out.println("The minimum number of mkultiplications required are: " + mcm.mcmMemo(nums));
		System.out.println("The minimum number of mkultiplications required are: " + mcm.mcmTabulation(nums));
	}

}
