package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class SubarraySumsDivisibleByK {

	// Given an integer array nums and an integer k, return the number of non-empty
	// subarrays that have a sum divisible by k.

	// A subarray is a contiguous part of an array.

	// efficient solution using hashing.
	public static int subarraysDivByK(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		hmap.put(0, 1);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			while (sum < 0) {
				sum = sum + k;
			}
			int r = sum % k;
			if (hmap.containsKey(r)) {
				count = count + hmap.get(r);
			}
			hmap.put(r, hmap.getOrDefault(r, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 5, 0, -2, -3, 1 };
		System.out.println("The count of subarrays with sum equal to k is: " + subarraysDivByK(nums, 5));
	}

}
