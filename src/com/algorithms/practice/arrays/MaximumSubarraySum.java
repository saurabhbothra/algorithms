package com.algorithms.practice.arrays;

public class MaximumSubarraySum {

	// Given an array, find out the maximum sum of a sub array in this array.
	// Sub arrays of {1,2,3} are {1}, {2}, {3}, {1,2}, {2,3} and {1,2,3}.

	// efficient solution, Kadane's Algorithm.
	public static int maxSumSubArray(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < sum + arr[i]) {
				sum = sum + arr[i];
			} else {
				sum = arr[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	// solution using divide and conquer.
	public int maxSubArray(int[] nums) {
		return sumRec(nums, 0, nums.length - 1);
	}

	private int sumRec(int[] nums, int left, int right) {
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
		int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
		int[] arr1 = { 5, 8, 3 };
		int[] arr2 = { -6, -1, -8 };
		int[] arr3 = { 5, 8, 3, -1 };
		System.out.println("The maximum sum of subarray in this array is: " + maxSumSubArray(arr));
		System.out.println("The maximum sum of subarray in this array is: " + maxSumSubArray(arr1));
		System.out.println("The maximum sum of subarray in this array is: " + maxSumSubArray(arr2));
		System.out.println("The maximum sum of subarray in this array is: " + maxSumSubArray(arr3));
	}

}
