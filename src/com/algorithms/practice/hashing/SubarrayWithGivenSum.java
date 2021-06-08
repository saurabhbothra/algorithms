package com.algorithms.practice.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSum {

	// Given an array of integers and a sum, find out if there is a sub array with a
	// given sum.

	// efficient solution.
	public static boolean subarraySum(int[] nums, int target) {
		Set<Integer> hset = new HashSet<>();
		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum = prefixSum + nums[i];
			if (hset.contains(prefixSum - target) || prefixSum == target) {
				return true;
			}
			hset.add(prefixSum);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 8, 6, 13, 3, -1 };
		int[] nums1 = { 15, 2, 8, 10, -5, -8, 6 };
		int[] nums2 = { 3, 2, 5, 6 };
		System.out.println("Is subarray with given sum: " + subarraySum(nums, 22));
		System.out.println("Is subarray with given sum: " + subarraySum(nums1, 3));
		System.out.println("Is subarray with given sum: " + subarraySum(nums2, 10));
	}

}
