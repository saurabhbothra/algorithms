package com.algorithms.practice.bitmagic;

public class MissingNumber {

	// Given an array nums containing n distinct numbers in the range [0, n], return
	// the only number in the range that is missing from the array.

	// Follow up: Could you implement a solution using only O(1) extra space
	// complexity and O(n) runtime complexity?

	// efficient solution, using bit manipulation.
	public static int missingNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i <= nums.length; i++) {
			if (i < nums.length) {
				res = res ^ nums[i];
			}
			res = res ^ i;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 0, 1 };
		System.out.println("The missing number is: " + missingNumber(nums));
	}

}
