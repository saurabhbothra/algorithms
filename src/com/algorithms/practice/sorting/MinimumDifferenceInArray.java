package com.algorithms.practice.sorting;

import java.util.Arrays;

public class MinimumDifferenceInArray {

	// Given an array of integers, find minimum difference in the array.

	// efficient solution.
	public static int minimumDifference(int[] nums) {
		int result = Integer.MAX_VALUE;
		if (nums.length <= 1) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			int difference = nums[i] - nums[i - 1];
			result = Math.min(result, difference);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 8, 12, 5, 18 };
		int[] arr1 = { 8, 15 };
		int[] arr2 = { 8, -1, 0, 3 };
		int[] arr3 = { 10 };
		System.out.println("The minimum difference in this array is: " + minimumDifference(arr));
		System.out.println("The minimum difference in this array is: " + minimumDifference(arr1));
		System.out.println("The minimum difference in this array is: " + minimumDifference(arr2));
		System.out.println("The minimum difference in this array is: " + minimumDifference(arr3));
	}

}
