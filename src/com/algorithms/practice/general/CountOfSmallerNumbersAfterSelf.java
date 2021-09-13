package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

	// You are given an integer array nums and you have to return a new counts
	// array. The counts array has the property where counts[i] is the number of
	// smaller elements to the right of nums[i].

	// solution using merge sort.
	public List<Integer> countSmaller(int[] nums) {
		int[] result = new int[nums.length];
		int[] positions = new int[nums.length];
		for (int i = 0; i < positions.length; i++) {
			positions[i] = i;
		}
		countRec(nums, result, positions, 0, nums.length - 1);
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			res.add(result[i]);
		}
		return res;
	}

	private void countRec(int[] nums, int[] result, int[] positions, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			countRec(nums, result, positions, start, mid);
			countRec(nums, result, positions, mid + 1, end);
			merge(nums, result, positions, start, mid, end);
		}
	}

	private void merge(int[] nums, int[] result, int[] positions, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		List<Integer> temp = new ArrayList<>();
		while (i <= mid && j <= end) {
			if (nums[positions[i]] <= nums[positions[j]]) {
				temp.add(positions[i]);
				result[positions[i]] += (j - mid) - 1;
				i++;
			} else {
				temp.add(positions[j]);
				j++;
			}
		}

		while (i <= mid) {
			temp.add(positions[i]);
			result[positions[i]] += (j - mid) - 1;
			i++;
		}

		while (j <= end) {
			temp.add(positions[j]);
			j++;
		}

		for (int k = 0; k < temp.size(); k++) {
			positions[start + k] = temp.get(k);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountOfSmallerNumbersAfterSelf cs = new CountOfSmallerNumbersAfterSelf();
		int[] nums = { 5, 2, 6, 1 };
		List<Integer> result = cs.countSmaller(nums);
		System.out.println("The results array is:");
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}

}
