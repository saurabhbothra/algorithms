package com.algorithms.practice.dp;

public class PartitionArrayForMaximumSum {

	// Given an integer array arr, partition the array into (contiguous) subarrays
	// of length at most k. After partitioning, each subarray has their values
	// changed to become the maximum value of that subarray.

	// Return the largest sum of the given array after partitioning. Test cases are
	// generated so that the answer fits in a 32-bit integer.

	// simple recursive solution.
	public int maxSumAfterPartitioningSimple(int[] arr, int k) {
		return maxSumRec(arr, k, 0);
	}

	public int maxSumRec(int[] arr, int k, int index) {
		if (index == arr.length) {
			return 0;
		}
		int maxValue = Integer.MIN_VALUE;
		int maxSum = Integer.MIN_VALUE;
		for (int i = index; i < index + k; i++) {
			if (i < arr.length) {
				maxValue = Math.max(maxValue, arr[i]);
				int subResult = (i - index + 1) * maxValue + maxSumRec(arr, k, i + 1);
				maxSum = Math.max(maxSum, subResult);
			}
		}
		return maxSum;
	}

	// memoization.
	public int maxSumAfterPartitioningMemo(int[] arr, int k) {
		Integer[] memo = new Integer[arr.length + 1];
		return maxSumRec(arr, k, 0, memo);
	}

	public int maxSumRec(int[] arr, int k, int index, Integer[] memo) {
		if (index == arr.length) {
			memo[index] = 0;
		}
		if (memo[index] == null) {
			int maxValue = Integer.MIN_VALUE;
			int maxSum = Integer.MIN_VALUE;
			for (int i = index; i < index + k; i++) {
				if (i < arr.length) {
					maxValue = Math.max(maxValue, arr[i]);
					int subResult = (i - index + 1) * maxValue + maxSumRec(arr, k, i + 1, memo);
					maxSum = Math.max(maxSum, subResult);
				}
			}
			memo[index] = maxSum;
		}
		return memo[index];
	}

	// tabulation.
	public int maxSumAfterPartitioningTabulation(int[] arr, int k) {
		int[] dp = new int[arr.length + 1];
		dp[arr.length] = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int maxValue = Integer.MIN_VALUE;
			int maxSum = Integer.MIN_VALUE;
			for (int j = i; j < i + k; j++) {
				if (j < arr.length) {
					maxValue = Math.max(maxValue, arr[j]);
					int subResult = (j - i + 1) * maxValue + dp[j + 1];
					maxSum = Math.max(maxSum, subResult);
				}
			}
			dp[i] = maxSum;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionArrayForMaximumSum pa = new PartitionArrayForMaximumSum();
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		System.out.println("The maximum sum after partitioning is: " + pa.maxSumAfterPartitioningSimple(arr, 3));
		System.out.println("The maximum sum after partitioning is: " + pa.maxSumAfterPartitioningMemo(arr, 3));
		System.out.println("The maximum sum after partitioning is: " + pa.maxSumAfterPartitioningTabulation(arr, 3));
	}

}
