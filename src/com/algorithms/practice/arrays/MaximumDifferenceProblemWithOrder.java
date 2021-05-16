package com.algorithms.practice.arrays;

public class MaximumDifferenceProblemWithOrder {

	// Given an array of integers, we need to find maximum value of arr[j] - arr[i]
	// such that j > i.

	// efficient solution, traversing from left.
	public static int findMaxDiffLeftTraversal(int[] arr) {
		int result = Integer.MIN_VALUE;
		int minValue = arr[0];
		for (int j = 1; j < arr.length; j++) {
			result = Math.max(arr[j] - minValue, result);
			minValue = Math.min(minValue, arr[j]);
		}
		return result;
	}

	// efficient solution, traversing from right.
	public static int findMaxDiff(int[] arr) {
		int maxValue = arr[arr.length - 1];
		int i = arr.length - 2;
		int result = Integer.MIN_VALUE;
		while (i >= 0) {
			result = Math.max(maxValue - arr[i], result);
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
			i--;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		int[] arr1 = { 7, 9, 5, 6, 3, 2 };
		int[] arr2 = { 10, 20, 30 };
		int[] arr3 = { 30, 10, 8, 2 };
		System.out.println("The maximum difference for the array is: " + findMaxDiff(arr));
		System.out.println("The maximum difference for the array is: " + findMaxDiff(arr1));
		System.out.println("The maximum difference for the array is: " + findMaxDiff(arr2));
		System.out.println("The maximum difference for the array is: " + findMaxDiff(arr3));
		System.out.println();
		System.out.println("The maximum difference for the array is: " + findMaxDiffLeftTraversal(arr));
		System.out.println("The maximum difference for the array is: " + findMaxDiffLeftTraversal(arr1));
		System.out.println("The maximum difference for the array is: " + findMaxDiffLeftTraversal(arr2));
		System.out.println("The maximum difference for the array is: " + findMaxDiffLeftTraversal(arr3));
	}

}
