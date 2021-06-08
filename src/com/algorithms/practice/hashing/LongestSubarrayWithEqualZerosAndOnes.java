package com.algorithms.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqualZerosAndOnes {

	// Given a binary array, find length of longest sub array with equal number of
	// zero's and one's.

	// efficient solution.
	public static int longestSubarray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		return maxSubArrayLen(arr, 0);
	}

	// helper method to find longest subarray with given sum.
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
		int[] nums = { 1, 0, 1, 1, 1, 0, 0 };
		int[] nums1 = { 1, 1, 1, 1 };
		int[] nums2 = { 0, 0, 1, 1, 1, 1, 1, 0 };
		int[] nums3 = { 0, 0, 1, 0, 1, 1 };
		System.out.println("Longest length of subarray is: " + longestSubarray(nums));
		System.out.println("Longest length of subarray is: " + longestSubarray(nums1));
		System.out.println("Longest length of subarray is: " + longestSubarray(nums2));
		System.out.println("Longest length of subarray is: " + longestSubarray(nums3));
	}

}
