package com.algorithms.practice.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsorted {

	// Given an array of integers nums and an integer target, return indices of the
	// two numbers such that they add up to target.

	// You may assume that each input would have exactly one solution, and you may
	// not use the same element twice.

	// You can return the answer in any order.

	// efficient solution.
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hmap.containsKey(complement)) {
				index1 = i;
				index2 = hmap.get(complement);
				break;
			} else {
				hmap.put(nums[i], i);
			}
		}
		return new int[] { index1, index2 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 11, 15 };
		System.out.println("The pair with given sum is: " + Arrays.toString(twoSum(nums, 9)));
	}

}
