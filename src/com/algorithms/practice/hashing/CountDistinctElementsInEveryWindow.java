package com.algorithms.practice.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {

	// Given an array of size n, and a number k, k <= n,
	// Find distinct element count in every window of size k in this array.

	// efficient solution.
	public static void countDistinctElements(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int zeroCount = 0;
		for (int i = 0; i < nums.length; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
			if (i >= k - 1) {
				int prevWindowIndex = i - k;
				if (prevWindowIndex >= 0) {
					hmap.put(nums[prevWindowIndex], hmap.get(nums[prevWindowIndex]) - 1);
					if (hmap.get(nums[prevWindowIndex]) == 0) {
						zeroCount++;
					}
				}
				System.out.print(hmap.size() - zeroCount + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 20, 20, 10, 30, 40, 10 };
		int[] nums1 = { 10, 10, 10, 10 };
		int[] nums2 = { 10, 20, 30, 40 };
		System.out.println("Distinct elements in every window are: ");
		countDistinctElements(nums, 4);
		System.out.println();
		countDistinctElements(nums1, 3);
		System.out.println();
		countDistinctElements(nums2, 3);
	}

}
