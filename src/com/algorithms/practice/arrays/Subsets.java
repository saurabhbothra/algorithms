package com.algorithms.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	// Given an integer array nums of unique elements, return all possible subsets
	// (the power set).

	// The solution set must not contain duplicate subsets. Return the solution in
	// any order.

	// efficient solution.
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		subRec(nums, 0, new ArrayList<>(), result);
		return result;
	}

	public void subRec(int[] nums, int index, List<Integer> subList, List<List<Integer>> result) {
		if (index == nums.length) {
			result.add(subList);
			return;
		}
		subRec(nums, index + 1, subList, result);
		List<Integer> temp = new ArrayList<>(subList);
		temp.add(nums[index]);
		subRec(nums, index + 1, temp, result);
	}

}
