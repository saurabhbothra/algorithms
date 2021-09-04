package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	// Given an integer array nums, return all the triplets [nums[i], nums[j],
	// nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	// nums[k] == 0.

	// Notice that the solution set must not contain duplicate triplets.

	// efficient solution, using sorting and two pointers.
	// we sort the array, we fix i and for array to the right of i, we follow two
	// pointers approach.
	// we also need to skip duplicates along the way.
	public List<List<Integer>> threeSumSort(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int sum = nums[i] * (-1);
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (nums[start] + nums[end] < sum) {
						start++;
					} else if (nums[start] + nums[end] > sum) {
						end--;
					} else {
						List<Integer> res = new ArrayList<>();
						res.add(nums[i]);
						res.add(nums[start]);
						res.add(nums[end]);
						result.add(res);
						start++;
						end--;
						while (start < end && nums[start] == nums[start - 1]) {
							start++;
						}
					}
				}
			}
		}
		return result;
	}

	// efficient solution, using sorting and hash set.
	public List<List<Integer>> threeSumSortSet(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int sum = nums[i] * (-1);
				Set<Integer> hset = new HashSet<>();
				int j = i + 1;
				while (j < nums.length) {
					int complement = sum - nums[j];
					if (hset.contains(complement)) {
						List<Integer> res = new ArrayList<>();
						res.add(nums[i]);
						res.add(nums[j]);
						res.add(complement);
						result.add(res);
						while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
							j++;
						}
					}
					hset.add(nums[j]);
					j++;
				}
			}
		}
		return result;
	}

}
