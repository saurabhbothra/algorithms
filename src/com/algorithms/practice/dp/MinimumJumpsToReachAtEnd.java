package com.algorithms.practice.dp;

public class MinimumJumpsToReachAtEnd {

	// Given an array of non-negative integers nums, you are initially positioned at
	// the first index of the array.

	// Each element in the array represents your maximum jump length at that
	// position.

	// Your goal is to reach the last index in the minimum number of jumps.

	// You can assume that you can always reach the last index.

	// 1 <= nums.length <= 10^4
	// 0 <= nums[i] <= 1000

	// simple recursive solution.
	public int jumpSimple(int[] nums) {
		return jumpRec(nums, 0);
	}

	public int jumpRec(int[] nums, int index) {
		if (index == nums.length - 1) {
			return 0;
		}
		int maxJumps = nums[index];
		int res = -1;
		for (int i = 1; i <= maxJumps; i++) {
			if (index + i < nums.length) {
				int subResult = jumpRec(nums, index + i);
				if (subResult != -1) {
					res = (res == -1) ? subResult + 1 : Math.min(res, subResult + 1);
				}
			}
		}
		return res;
	}

	// memoization.
	public int jumpMemo(int[] nums) {
		Integer[] memo = new Integer[nums.length];
		return jumpRec(nums, 0, memo);
	}

	public int jumpRec(int[] nums, int index, Integer[] memo) {
		if (index == nums.length - 1) {
			memo[index] = 0;
		}
		if (memo[index] == null) {
			int maxJumps = nums[index];
			int res = -1;
			for (int i = 1; i <= maxJumps; i++) {
				if (index + i < nums.length) {
					int subResult = jumpRec(nums, index + i, memo);
					if (subResult != -1) {
						res = (res == -1) ? subResult + 1 : Math.min(res, subResult + 1);
					}
				}
			}
			memo[index] = res;
		}
		return memo[index];
	}

	// tabulation.
	public int jumpTabulation(int[] nums) {
		int[] dp = new int[nums.length];
		dp[nums.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			int res = -1;
			int maxJumps = nums[i];
			for (int j = 1; j <= maxJumps; j++) {
				if (i + j < nums.length) {
					int subResult = dp[i + j];
					if (subResult != -1) {
						res = (res == -1) ? subResult + 1 : Math.min(res, subResult + 1);
					}
				}
			}
			dp[i] = res;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumJumpsToReachAtEnd mj = new MinimumJumpsToReachAtEnd();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("The minimum number of jumps required is: " + mj.jumpSimple(nums));
		System.out.println("The minimum number of jumps required is: " + mj.jumpMemo(nums));
		System.out.println("The minimum number of jumps required is: " + mj.jumpTabulation(nums));
	}

}
