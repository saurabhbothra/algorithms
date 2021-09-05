package com.algorithms.practice.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxKSumPairs {

	// You are given an integer array nums and an integer k.

	// In one operation, you can pick two numbers from the array whose sum equals k
	// and remove them from the array.

	// Return the maximum number of operations you can perform on the array.

	// efficient solution, using two pointers and sorting.
	public static int maxOperations(int[] nums, int k) {
		int count = 0;
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] < k) {
				start++;
			} else if (nums[start] + nums[end] > k) {
				end--;
			} else {
				count++;
				start++;
				end--;
			}
		}
		return count;
	}

	// efficient implementation, using hash map.
	public static int maxOperationsHash(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int complement = k - nums[i];
			if (hmap.containsKey(complement) && hmap.get(complement) != 0) {
				count++;
				hmap.put(complement, hmap.get(complement) - 1);
			} else {
				hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 3, 4, 3 };
		System.out.println(maxOperations(nums, 6));
		System.out.println(maxOperationsHash(nums, 6));
	}

}
