package com.algorithms.practice.arrays;

public class MaximumProductSubarray {

	// Given an integer array nums, find a contiguous non-empty subarray within the
	// array that has the largest product, and return the product.

	// It is guaranteed that the answer will fit in a 32-bit integer.

	// A subarray is a contiguous subsequence of the array.

	// efficient solution using kadane's algorithm.
	public static int maxProduct(int[] nums) {
		int result = Integer.MIN_VALUE;
		int maxProduct = 1;
		int minProduct = 1;
		for (int i = 0; i < nums.length; i++) {
			int a = maxProduct * nums[i];
			int b = minProduct * nums[i];
			maxProduct = Math.max(a, Math.max(b, nums[i]));
			minProduct = Math.min(a, Math.min(b, nums[i]));
			result = Math.max(result, maxProduct);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(maxProduct(nums));
	}

}
