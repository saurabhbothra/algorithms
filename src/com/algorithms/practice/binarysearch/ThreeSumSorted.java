package com.algorithms.practice.binarysearch;

public class ThreeSumSorted {

	// Given a sorted array and a sum, find if there is a triplet present with that
	// sum.

	// efficient solution.
	public static boolean isTripletPresent(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i] + twoSumSorted(arr, x - arr[i], i + 1, arr.length - 1);
			if (sum == x) {
				return true;
			}
		}
		return false;
	}

	// helper method for two pointer approach.
	private static int twoSumSorted(int[] numbers, int target, int start, int end) {
		int sum = 0;
		while (start < end) {
			sum = numbers[start] + numbers[end];
			if (sum == target) {
				return sum;
			}
			if (sum > target) {
				end--;
			} else {
				start++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 4, 8, 9, 20, 40 };
		System.out.println("Is triplet present in the array: " + isTripletPresent(arr, 32));
	}

}
