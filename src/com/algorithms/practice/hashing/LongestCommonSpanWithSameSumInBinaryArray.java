package com.algorithms.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSpanWithSameSumInBinaryArray {

	// We are given two binary arrays of same sizes. We need to find out the length
	// of the longest common sub array (same sizes in both sub arrays) such that sum
	// of elements in both sub arrays are same.

	// naive solution.
	public static int longestCommonSpanNaive(int[] nums1, int[] nums2) {
		int maxLength = 0;
		for (int i = 0; i < nums1.length; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = i; j < nums1.length; j++) {
				sum1 = sum1 + nums1[j];
				sum2 = sum2 + nums2[j];
				if (sum1 == sum2) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}
		return maxLength;
	}

	// efficient solution.
	public static int longestCommonSpan(int[] nums1, int[] nums2) {
		int[] temp = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			temp[i] = nums1[i] - nums2[i];
		}
		return maxSubArrayLen(temp, 0);
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
		int[] nums1 = { 0, 1, 0, 0, 0, 0 };
		int[] nums2 = { 1, 0, 1, 0, 0, 1 };
		int[] nums3 = { 0, 1, 0, 1, 1, 1, 1 };
		int[] nums4 = { 1, 1, 1, 1, 1, 0, 1 };
		int[] nums5 = { 0, 0, 0 };
		int[] nums6 = { 1, 1, 1 };
		int[] nums7 = { 0, 0, 1, 0 };
		int[] nums8 = { 1, 1, 1, 1 };
		System.out.println("The length of longest common span is: " + longestCommonSpan(nums1, nums2));
		System.out.println("The length of longest common span is: " + longestCommonSpan(nums3, nums4));
		System.out.println("The length of longest common span is: " + longestCommonSpan(nums5, nums6));
		System.out.println("The length of longest common span is: " + longestCommonSpan(nums7, nums8));
	}

}
