package com.algorithms.practice.recursion;

public class SubsetSumProblem {

	// Given an array and a sum, find count of subsets of this array whose sum is
	// equal to the given sum.
	// An array of length n will have 2^n subsets.
	// Subsets of [1,2,3] are, [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3].

	// recursive method.
	public static int findSubsets(int[] arr, int sum, int level, int actualSum) {
		if (level == arr.length) {
			if (actualSum == sum) {
				return 1;
			} else {
				return 0;
			}
		}
		int leftCount = findSubsets(arr, sum, level + 1, actualSum);
		int rightCount = findSubsets(arr, sum, level + 1, actualSum + arr[level]);
		return leftCount + rightCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 5, 2, 3, 6 };
		System.out.println("The number of subsets of this array with given sum is: " + findSubsets(arr, 8, 0, 0));
	}

}
