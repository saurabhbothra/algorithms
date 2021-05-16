package com.algorithms.practice.arrays;

public class RemoveDuplicatesSortedArray {

	// Given a sorted array, remove the duplicates in-place such that each
	// element appears only once and returns the new length.
	// Do not allocate extra space for another array, you must do this by modifying
	// the input array in-place with O(1) extra memory.

	// efficient solution, using two pointers.
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int pointer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[pointer]) {
				pointer++;
				nums[pointer] = nums[i];
			}
		}
		return pointer + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 20, 30, 30, 30, 30 };
		System.out.println("The size of array after removing duplicates is: " + removeDuplicates(arr));
	}

}
