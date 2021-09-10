package com.algorithms.practice.general;

public class MaximumSubarray {

	// Given an integer array nums, find the contiguous subarray (containing at
	// least one number) which has the largest sum and return its sum.

	// A subarray is a contiguous part of an array.

	// Follow up: If you have figured out the O(n) solution, try coding another
	// solution using the divide and conquer approach, which is more subtle.

	// efficient solution using kadane's algorithm.
	public static int maxSumKadane(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] < nums[i]) {
				sum = nums[i];
			} else {
				sum = sum + nums[i];
			}
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

	// Idea:
	
	// If we were to split our input in half, then logically the optimal subarray
	// either:

	// Uses elements only from the left side
	// Uses elements only from the right side
	// Uses a combination of elements from both the left and right side
	// Thus, the answer is simply the largest of:

	// The maximum subarray contained only in the left side
	// The maximum subarray contained only in the right side
	// The maximum subarray that can use elements from both sides

	// efficient solution using divide and conquer.
	public static int maxSumDivide(int[] nums) {
		return sumRec(nums, 0, nums.length - 1);
	}

	private static int sumRec(int[] nums, int left, int right) {
		if (left > right) {
			return Integer.MIN_VALUE;
		}
		int curr = 0;
		int leftBestSum = 0;
		int rightBestSum = 0;
		int mid = left + (right - left) / 2;
		for (int i = mid - 1; i >= left; i--) {
			curr += nums[i];
			leftBestSum = Math.max(leftBestSum, curr);
		}
		curr = 0;
		for (int i = mid + 1; i <= right; i++) {
			curr += nums[i];
			rightBestSum = Math.max(rightBestSum, curr);
		}

		int bestSum = leftBestSum + rightBestSum + nums[mid];

		int leftSum = sumRec(nums, left, mid - 1);
		int rightSum = sumRec(nums, mid + 1, right);
		return Math.max(bestSum, Math.max(leftSum, rightSum));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("The maximum sum is: " + maxSumKadane(nums));
		System.out.println("The maximum sum is: " + maxSumDivide(nums));
	}

}
