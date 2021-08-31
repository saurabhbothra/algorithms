package com.algorithms.practice.bitmagic;

public class OneOddOccurring {

	// Given an array of integers, find number that has odd occurrences in the
	// array. There will be only one such number.

	// efficient implementation, using bit manipulation.
	public static int findOddOccurringElement(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 4, 4, 4, 5, 5 };
		int[] nums1 = { 8, 7, 7, 8, 8 };
		System.out.println("The odd occurring element is: " + findOddOccurringElement(nums));
		System.out.println("The odd occurring element is: " + findOddOccurringElement(nums1));
	}

}
