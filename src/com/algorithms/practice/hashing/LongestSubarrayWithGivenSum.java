package com.algorithms.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSum {

	// Given an integer array nums and an integer k, return the maximum length of a
	// subarray that sums to k. If there isn't one, return 0 instead.

	// efficient solution.
	public static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int prefixSum = 0;
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum = prefixSum + nums[i];
			if (prefixSum == k) {
				if (maxLength < (i + 1)) {
					maxLength = i + 1;
				}
			}
			if (hmap.containsKey(prefixSum - k)) {
				int len = i - hmap.get(prefixSum - k);
				if (len > maxLength) {
					maxLength = len;
				}
			} else {
				if (!hmap.containsKey(prefixSum)) {
					hmap.put(prefixSum, i);
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, -1, 5, -2, 3 };
		System.out.println("The maximum length of the subarray with given sum is: " + maxSubArrayLen(nums, 3));
	}

}
