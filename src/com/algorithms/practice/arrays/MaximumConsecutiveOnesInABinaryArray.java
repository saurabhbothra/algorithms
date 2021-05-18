package com.algorithms.practice.arrays;

public class MaximumConsecutiveOnesInABinaryArray {

	// Given a binary array nums, return the maximum number of consecutive 1's in
	// the array.
	// 1 <= nums.length <= 10^5

	// efficient solution.
	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}
		if (count > maxCount) {
			maxCount = count;
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println("Maximum consecutive one's are: " + findMaxConsecutiveOnes(nums));
	}

}
