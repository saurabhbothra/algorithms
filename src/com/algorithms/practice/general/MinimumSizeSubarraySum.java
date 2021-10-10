package com.algorithms.practice.general;

public class MinimumSizeSubarraySum {

	// Given an array of positive integers nums and a positive integer target,
	// return the minimal length of a contiguous subarray [numsl, numsl+1, ...,
	// numsr-1, numsr] of which the sum is greater than or equal to target. If there
	// is no such subarray, return 0 instead.

	// efficient solution.
	public static int minSubArrayLen(int target, int[] nums) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum += nums[j];
			if (sum >= target) {
				len = Math.min(len, j - i + 1);
				do {
					sum = sum - nums[i];
					i++;
					if (sum >= target) {
						len = Math.min(len, j - i + 1);
					} else {
						break;
					}
				} while (i <= j);
			}
			j++;
		}
		return (len == Integer.MAX_VALUE) ? 0 : len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(7, nums));
	}

}
