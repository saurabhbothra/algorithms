package com.algorithms.practice.arrays;

import java.util.Arrays;

public class LeftRotateByD {

	// Given an array and a number d, left rotate this array by d places.
	// Assume d <= number of elements in the array.
	// Assume that length of the array is >= 1.

	// approach 1, theta(d) extra space.
	public static void leftRotateByD(int[] nums, int d) {
		int[] tempArr = new int[d];
		for (int i = 0; i < nums.length; i++) {
			if (i < d) {
				tempArr[i] = nums[i];
			} else {
				nums[i - d] = nums[i];
			}
		}
		for (int i = 0; i < d; i++) {
			nums[nums.length - d + i] = tempArr[i];
		}
	}

	// approach 2, theta(1) space.
	public static void leftRotateByDApproach2(int[] nums, int d) {
		reverse(nums, 0, d - 1);
		reverse(nums, d, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	// approach 3, naive solution.
	public static void leftRotateByDApproach3(int[] nums, int d) {
		for (int i = 0; i < d; i++) {
			leftRotateByOne(nums);
		}
	}

	// helper method to reverse an array.
	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}

	// helper method to left rotate an array by one place.
	private static void leftRotateByOne(int[] nums) {
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i - 1] = nums[i];
		}
		nums[nums.length - 1] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 5, 30, 15 };
		leftRotateByD(arr, 3);
		System.out.println("The array after left rotation by one looks like: " + Arrays.toString(arr));
		int[] arr1 = { 10, 5, 30, 15 };
		leftRotateByDApproach2(arr1, 3);
		System.out.println("The array after left rotation by one looks like: " + Arrays.toString(arr1));
		int[] arr2 = { 10, 5, 30, 15 };
		leftRotateByDApproach3(arr2, 3);
		System.out.println("The array after left rotation by one looks like: " + Arrays.toString(arr2));
	}

}
