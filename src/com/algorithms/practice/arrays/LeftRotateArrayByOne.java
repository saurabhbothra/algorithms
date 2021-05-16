package com.algorithms.practice.arrays;

import java.util.Arrays;

public class LeftRotateArrayByOne {

	// Given an array, you have to left rotate an array by one.
	// You have to do it in place.

	// efficient solution.
	public static void leftRotateByOne(int[] nums) {
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i - 1] = nums[i];
		}
		nums[nums.length - 1] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 30, 5, 20 };
		leftRotateByOne(arr);
		System.out.println("The array after left rotation by one looks like: " + Arrays.toString(arr));
	}

}
