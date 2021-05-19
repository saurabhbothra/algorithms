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
