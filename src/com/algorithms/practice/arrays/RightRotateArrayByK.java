package com.algorithms.practice.arrays;

import java.util.Arrays;

public class RightRotateArrayByK {

	// Given an array nums, rotate the array to the right by k steps, where k is
	// non-negative.
	// 1 <= nums.length <= 10^5

	// approach 1, theta(nk) extra space, naive solution.
	public static void rightRotateByK(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			rightRotateByOne(nums);
		}
	}

	// approach 2, theta(k) space.
	public static void rightRotateByKApproach2(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		int[] temp = new int[k];
		int index = temp.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i >= nums.length - k) {
				temp[index] = nums[i];
				index--;
			} else {
				nums[i + k] = nums[i];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			nums[i] = temp[i];
		}
	}

	// approach 3, theta(1) space.
	public static void rightRotateByKApproach3(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
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

	// helper method to right rotate an array by one place.
	private static void rightRotateByOne(int[] nums) {
		int temp = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			nums[i + 1] = nums[i];
		}
		nums[0] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -1, -100, 3, 99 };
		rightRotateByK(arr, 2);
		System.out.println("The array after right rotation by k looks like: " + Arrays.toString(arr));
		int[] arr1 = { -1, -100, 3, 99 };
		rightRotateByKApproach2(arr1, 2);
		System.out.println("The array after right rotation by k looks like: " + Arrays.toString(arr1));
		int[] arr2 = { -1, -100, 3, 99 };
		rightRotateByKApproach3(arr2, 2);
		System.out.println("The array after right rotation by k looks like: " + Arrays.toString(arr2));
	}

}
