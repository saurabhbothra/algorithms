package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	// Given an array nums of n integers, return an array of all the unique
	// quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

	// 0 <= a, b, c, d < n
	// a, b, c, and d are distinct.
	// nums[a] + nums[b] + nums[c] + nums[d] == target
	// You may return the answer in any order.

	// efficient solution, using sorting and two pointers.
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				threeSum(nums, target - nums[i], i, result);
			}
		}
		return result;
	}

	private void threeSum(int[] nums, int target, int i, List<List<Integer>> result) {
		for (int j = i + 1; j < nums.length; j++) {
			if (j == i + 1 || nums[j] != nums[j - 1]) {
				int sum = target - nums[j];
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (nums[start] + nums[end] < sum) {
						start++;
					} else if (nums[start] + nums[end] > sum) {
						end--;
					} else {
						result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
						start++;
						end--;
						while (start < nums.length && nums[start] == nums[start - 1]) {
							start++;
						}
					}
				}
			}
		}
	}

	// efficient implementation, using sorting and hash set.
	public List<List<Integer>> fourSumSet(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				threeSumSet(nums, target - nums[i], i, result);
			}
		}
		return result;
	}

	public void threeSumSet(int[] nums, int target, int i, List<List<Integer>> result) {
		for (int j = i + 1; j < nums.length; j++) {
			if (j == i + 1 || nums[j] != nums[j - 1]) {
				int sum = target - nums[j];
				Set<Integer> hset = new HashSet<>();
				for (int k = j + 1; k < nums.length; k++) {
					int complement = sum - nums[k];
					if (hset.contains(complement)) {
						result.add(Arrays.asList(nums[i], nums[j], complement, nums[k]));
						while (k + 1 < nums.length && nums[k + 1] == nums[k]) {
							k++;
						}
					}
					hset.add(nums[k]);
				}
			}
		}
	}

}
