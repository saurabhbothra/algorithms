package com.algorithms.practice.dp;

public class SubsetSumProblem {

	// Given an array and a sum, find count of subsets of this array whose sum is
	// equal to the given sum.

	// An array of length n will have 2^n subsets.
	// Subsets of [1,2,3] are, [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3].

	// simple recursive solution.
	public int findSubsetsWithSumKSimple(int[] nums, int k) {
		return findSubRec(nums, k, 0);
	}

	public int findSubRec(int[] nums, int k, int level) {
		if (k == 0) {
			return 1;
		}
		if (level == nums.length) {
			return 0;
		}
		int count = 0;
		count = count + findSubRec(nums, k, level + 1);
		if (k >= nums[level]) {
			count = count + findSubRec(nums, k - nums[level], level + 1);
		}
		return count;
	}

	// memoization.
	public int findSubsetsMemo(int[] nums, int k) {
		Integer[][] memo = new Integer[k + 1][nums.length + 1];
		return findSubRec(nums, k, nums.length, memo);
	}

	public int findSubRec(int[] nums, int k, int level, Integer[][] memo) {
		if (k == 0) {
			memo[k][level] = 1;
		}
		if (level == 0) {
			memo[k][level] = 0;
		}
		if (memo[k][level] == null) {
			int count = 0;
			count = count + findSubRec(nums, k, level - 1, memo);
			if (k >= nums[level - 1]) {
				count = count + findSubRec(nums, k - nums[level - 1], level - 1, memo);
			}
			memo[k][level] = count;
		}
		return memo[k][level];
	}

	// tabulation.
	public int findSubsetsTabulation(int[] nums, int k) {
		int[][] dp = new int[k + 1][nums.length + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= nums.length; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i >= nums[j - 1]) {
					dp[i][j] += dp[i - nums[j - 1]][j - 1];
				}
			}
		}
		return dp[k][nums.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetSumProblem ssp = new SubsetSumProblem();
		int[] arr = { 10, 5, 2, 3, 6 };
		System.out.println("The number of subsets with given sum are: " + ssp.findSubsetsWithSumKSimple(arr, 8));
		System.out.println("The number of subsets with given sum are: " + ssp.findSubsetsMemo(arr, 8));
		System.out.println("The number of subsets with given sum are: " + ssp.findSubsetsTabulation(arr, 8));
	}

}
