package com.algorithms.practice.arrays;

public class MaximumCircularSumSubarray {

	// Given a circular array circ of integers represented by nums, find the maximum
	// possible sum of a non-empty subarray of circ.

	// Here, a circular array means the end of the array connects to the beginning
	// of the array. (Formally, circ[i] = nums[i] when 0 <= i < nums.length, and
	// circ[i+nums.length] = circ[i] when i >= 0.)

	// Also, a subarray may only include each element of the fixed buffer nums at
	// most once. (Formally, for a subarray circ[i], circ[i+1], ..., circ[j], there
	// does not exist i <= k1, k2 <= j with k1 % nums.length = k2 % nums.length.)

	// 1 <= nums

	// efficient solution.
	public static int maxSubarraySumCircular(int[] nums) {
		// get linear maximum sum.
		int maxLinearSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] > nums[i]) {
				sum = sum + nums[i];
			} else {
				sum = nums[i];
			}
			if (sum > maxLinearSum) {
				maxLinearSum = sum;
			}
		}

		// get total sum.
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum = totalSum + nums[i];
		}

		// get linear minimum sum.
		int minLinearSum = Integer.MAX_VALUE;
		sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] < nums[i]) {
				sum = sum + nums[i];
			} else {
				sum = nums[i];
			}
			if (sum < minLinearSum) {
				minLinearSum = sum;
			}
		}
		
		// maximum circular sum will be total sum minus the minimum linear sum.
		int maxCircularSum = (minLinearSum == totalSum) ? Integer.MIN_VALUE : totalSum - minLinearSum;
		// return maximum of maximum linear sum and maximum circular sum.
		return Math.max(maxLinearSum, maxCircularSum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, -1, 2, -1 };
		System.out.println("The maximum length of subarray is: " + maxSubarraySumCircular(arr));
	}

}
