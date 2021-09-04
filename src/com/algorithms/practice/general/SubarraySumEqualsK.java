package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class SubarraySumEqualsK {

	// Given an array of integers nums and an integer k, return the total number of
	// continuous subarrays whose sum equals to k.

	// efficient solution.
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> hmap = new HashMap<>();
		hmap.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			int complement = sum - k;
			if (hmap.containsKey(complement)) {
				count = count + hmap.get(complement);
			}
			hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 5, -5, 7, 7, -7, 5, 0 };
		System.out.println("Total subarrays are: " + subarraySum(nums, 12));
	}

}
