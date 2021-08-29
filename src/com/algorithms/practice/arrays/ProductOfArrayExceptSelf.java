package com.algorithms.practice.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	// Given an integer array nums, return an array answer such that answer[i] is
	// equal to the product of all the elements of nums except nums[i].

	// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
	// integer.

	// You must write an algorithm that runs in O(n) time and without using the
	// division operation.

	// Follow up: Can you solve the problem in O(1) extra space complexity? (The
	// output array does not count as extra space for space complexity analysis.)

	// efficient solution with space.
	public static int[] productExceptSelfEff(int[] nums) {
		int[] leftProduct = new int[nums.length];
		int[] rightProduct = new int[nums.length];
		int[] result = new int[nums.length];
		leftProduct[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			leftProduct[i] = leftProduct[i - 1] * nums[i];
		}
		rightProduct[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			rightProduct[i] = rightProduct[i + 1] * nums[i];
		}
		result[0] = rightProduct[1];
		result[nums.length - 1] = leftProduct[nums.length - 2];
		for (int i = 1; i < nums.length - 1; i++) {
			result[i] = leftProduct[i - 1] * rightProduct[i + 1];
		}
		return result;
	}

	// efficient solution without space.
	public static int[] productExceptSelfBest(int[] nums) {
		int leftProduct = 1;
		int rightProduct = 1;
		int[] result = new int[nums.length];
		result[0] = 1;
		result[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			leftProduct = leftProduct * nums[i - 1];
			result[i] = leftProduct;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			rightProduct = rightProduct * nums[i + 1];
			result[i] = result[i] * rightProduct;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 1, 0, -3, 3 };
		System.out.println("The result array is: " + Arrays.toString(productExceptSelfEff(nums)));
		System.out.println("The result array is: " + Arrays.toString(productExceptSelfBest(nums)));
	}

}
