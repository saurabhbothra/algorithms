package com.algorithms.practice.arrays;

import java.util.Arrays;

public class MoveZerosToEnd {

	// Given an integer array, move all 0's to the end of it while maintaining
	// the relative order of the non-zero elements.
	// Note that you must do this in-place without making a copy of the array.
	// Assume, length of array is greater than zero.

	// Could you minimize the total number of operations done?

	public static void moveZeroes(int[] nums) {
		int pointer = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				pointer++;
				int temp = nums[i];
				nums[i] = 0;
				nums[pointer] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 0, 3, 12 };
		moveZeroes(arr);
		System.out.println("The modified array after shifting zeros to end is: " + Arrays.toString(arr));
	}

}
