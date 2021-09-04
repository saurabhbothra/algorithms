package com.algorithms.practice.arrays;

import java.util.Arrays;

public class TwoSumLessThanK {

	// Given an array nums of integers and integer k, return the maximum sum such
	// that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j
	// exist satisfying this equation, return -1.

	// efficient solution, using two pointers and sorting.
	public static int twoSumLessThanK(int[] nums, int k) {
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		int result = -1;
		while (i < j) {
			if (nums[i] + nums[j] < k) {
				result = Math.max(result, nums[i] + nums[j]);
				i++;
			} else {
				j--;
			}
		}
		return result;
	}

	// efficient solution, using binary search.
	public static int twoSumLessThanKBinary(int[] nums, int k) {
		int result = -1;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int complement = k - nums[i];
			int subResult = binarySearch(nums, i, complement);
			result = Math.max(result, subResult);
		}
		return result;
	}

	public static int binarySearch(int[] nums, int i, int x) {
		int start = i + 1;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < x) {
				if (mid != nums.length - 1 && nums[mid + 1] < x) {
					start = mid + 1;
				} else {
					return nums[i] + nums[mid];
				}
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;
		System.out.println("Maximum sum less than k is: " + twoSumLessThanK(nums, k));
		System.out.println("Maximum sum less than k is: " + twoSumLessThanKBinary(nums, k));
	}

}
