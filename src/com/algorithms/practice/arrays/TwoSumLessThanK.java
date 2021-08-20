package com.algorithms.practice.arrays;

import java.util.Arrays;

public class TwoSumLessThanK {

	// Given an array nums of integers and integer k, return the maximum sum such
	// that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
	// exist satisfying this equation, return -1.

	// efficient solution.
	public static int twoSumLessThanK(int[] nums, int k) {
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		int result = -1;
		while (i < j) {
			int complement = k - i;
			if (nums[i] + nums[j] < k) {
				result = Math.max(result, nums[i] + nums[j]);
				i++;
			} else {
				j--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;
		System.out.println("Maximum sum less than k is: " + twoSumLessThanK(nums, k));
	}

}
