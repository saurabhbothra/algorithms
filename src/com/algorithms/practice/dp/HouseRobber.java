package com.algorithms.practice.dp;

public class HouseRobber {

	// You are a professional robber planning to rob houses along a street. Each
	// house has a certain amount of money stashed, the only constraint stopping you
	// from robbing each of them is that adjacent houses have security systems
	// connected and it will automatically contact the police if two adjacent houses
	// were broken into on the same night.

	// Given an integer array nums representing the amount of money of each house,
	// return the maximum amount of money you can rob tonight without alerting the
	// police.

	// 1 <= nums.length <= 100.
	// 0 <= nums[i] <= 400.

	// simple recursive solution.
	public int robSimple(int[] nums) {
		return robRec(nums, nums.length - 1);
	}

	public int robRec(int[] nums, int n) {
		if (n == 0) {
			return nums[0];
		}
		int maxSum = Integer.MIN_VALUE;
		for (int i = n - 2; i >= 0; i--) {
			int subResult = robRec(nums, i);
			maxSum = Math.max(subResult, maxSum);
		}
		if (maxSum == Integer.MIN_VALUE) {
			maxSum = nums[n];
		} else {
			maxSum += nums[n];
		}
		return Math.max(maxSum, robRec(nums, n - 1));
	}

	// memoization.
	public int robMemo(int[] nums) {
		Integer[] memo = new Integer[nums.length];
		return robRec(nums, nums.length - 1, memo);
	}

	public int robRec(int[] nums, int n, Integer[] memo) {
		if (n == 0) {
			memo[n] = nums[0];
		}
		if (memo[n] == null) {
			int maxSum = Integer.MIN_VALUE;
			for (int i = n - 2; i >= 0; i--) {
				int subResult = robRec(nums, i, memo);
				maxSum = Math.max(subResult, maxSum);
			}
			if (maxSum == Integer.MIN_VALUE) {
				maxSum = nums[n];
			} else {
				maxSum += nums[n];
			}
			memo[n] = Math.max(maxSum, robRec(nums, n - 1, memo));
		}
		return memo[n];
	}

	// tabulation.
	public int robTabulation(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	// tabulation, space optimized.
	public int robTabulationEfficient(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int alternate = 0;
		int prev = nums[0];
		int curr = 0;
		for (int i = 1; i < nums.length; i++) {
			curr = Math.max(nums[i] + alternate, prev);
			alternate = prev;
			prev = curr;
		}
		return curr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber hr = new HouseRobber();
		int[] nums = { 2, 7, 9, 3, 1 };
		System.out.println("The maximum money you can rob is: " + hr.robSimple(nums));
		System.out.println("The maximum money you can rob is: " + hr.robMemo(nums));
		System.out.println("The maximum money you can rob is: " + hr.robTabulation(nums));
		System.out.println("The maximum money you can rob is: " + hr.robTabulationEfficient(nums));
	}

}
