package com.algorithms.practice;

public class demo {

	public int inverseMemo(int[] nums, int k) {
		Integer[][] memo = new Integer[k + 1][nums.length + 1];
		return inversionRec(nums, k, 0, memo);
	}

	public int inversionRec(int[] nums, int k, int index, Integer[][] memo) {
		if (k == 1) {
			memo[k][index] = 1;
		} else if (index == nums.length) {
			memo[k][index] = 0;
		}
		if (memo[k][index] == null) {
			int count = 0;
			for (int i = index + 1; i < nums.length; i++) {
				if (nums[index] > nums[i]) {
					count = count + inversionRec(nums, k - 1, i, memo);
				}
			}
			if (k == 3) {
				count = count + inversionRec(nums, k, index + 1, memo);
			}
			memo[k][index] = count;
		}
		return memo[k][index];
	}

	public int inversionTabulation(int[] nums, int k) {
		int[][] dp = new int[k + 1][nums.length + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= k; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				int count = 0;
				for (int a = j + 1; a < nums.length; a++) {
					if (nums[j] > nums[a]) {
						count = count + dp[i - 1][a];
					}
				}
				if (i == 3) {
					count = count + dp[i][j + 1];
				}
				dp[i][j] = count;
			}
		}
		return dp[k][0];
	}

	public static void main(String[] args) {
		int[] nums = { 6, 5, 4, 3, 2, 1 };
		int[] nums1 = { 5, 5, 2, 2, 1 };
		demo d = new demo();
		System.out.println(d.inverseMemo(nums, 3));
		System.out.println(d.inverseMemo(nums1, 3));

		System.out.println(d.inversionTabulation(nums, 3));
		System.out.println(d.inversionTabulation(nums1, 3));
	}
}
