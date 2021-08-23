package com.algorithms.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

	// Given an integer array nums that may contain duplicates, return all possible
	// subsets (the power set).

	// The solution set must not contain duplicate subsets. Return the solution in
	// any order.

	// efficient solution.
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		subRec(nums, 0, new ArrayList<>(), result);
		return result;
	}

	public void subRec(int[] nums, int index, List<Integer> subList, List<List<Integer>> result) {
		result.add(new ArrayList<>(subList));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			subList.add(nums[i]);
			subRec(nums, i + 1, subList, result);
			subList.remove(subList.size() - 1);
		}
	}

}
