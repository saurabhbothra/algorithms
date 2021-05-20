package com.algorithms.practice.arrays;

public class MaximumSumKConsecutiveElements {

	// Given an array of integers and a number k, find the maximum sum of k
	// consecutive elements.

	// efficient solution, sliding window technique.
	public static int maxSumKConsecutiveElements(int[] arr, int k) {
		if (arr.length < k) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + arr[i];
		}
		int maxSum = sum;
		for (int i = k; i < arr.length; i++) {
			sum = sum + arr[i] - arr[i - k];
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 8, 30, -5, 20, 7 };
		int[] arr1 = { 5, -10, 6, 90, 3 };
		System.out.println(
				"The maximum sum of k consecutive elements in this array is: " + maxSumKConsecutiveElements(arr, 3));
		System.out.println(
				"The maximum sum of k consecutive elements in this array is: " + maxSumKConsecutiveElements(arr1, 2));
	}

}
