package com.algorithms.practice.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {

	// Given an array of integers, find if there is a sub array with zero sum.

	// efficient solution.
	public static boolean isSubarrayWithZeroSum(int[] nums) {
		Set<Integer> hset = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if (hset.contains(sum) || sum == 0) {
				return true;
			}
			hset.add(sum);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 4, 13, -3, -10, 5 };
		int[] nums1 = { -1, 4, -3, 5, 1 };
		int[] nums2 = { 3, 1, -2, 5, 6 };
		int[] nums3 = { 5, 6, 0, 8 };
		System.out.println("Is subarray with zero sum: " + isSubarrayWithZeroSum(nums));
		System.out.println("Is subarray with zero sum: " + isSubarrayWithZeroSum(nums1));
		System.out.println("Is subarray with zero sum: " + isSubarrayWithZeroSum(nums2));
		System.out.println("Is subarray with zero sum: " + isSubarrayWithZeroSum(nums3));
	}

}
