package com.algorithms.practice.arrays;

public class MajorityElement {

	// Given an array nums of size n, return the majority element.

	// The majority element is the element that appears more than ⌊n / 2⌋ times. You
	// may assume that the majority element always exists in the array.
	// 1 <= n

	// efficient solution, Boyer-Moore Voting Algorithm
	public static int majorityElement(int[] nums) {
		int result = 0;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[result]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				result = i;
			}
		}
		return nums[result];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println("The majority element in the given array is: " + majorityElement(nums));
	}

}
