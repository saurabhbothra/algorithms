package com.algorithms.practice.binarysearch;

import java.util.Arrays;

public class IndexOfFirstAndLastOccurrenceInSortedArray {

	// Given an array of integers nums sorted in ascending order, find the starting
	// and ending position of a given target value.

	// If target is not found in the array, return [-1, -1].
	// 0 <= nums.length <= 10^5

	// efficient solution, binary search.
	public static int[] searchRange(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int leftIndex = -1;
		int rightIndex = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				if (mid == 0 || nums[mid] != nums[mid - 1]) {
					leftIndex = mid;
					break;
				} else {
					end = mid - 1;
				}
			}
		}

		start = 0;
		end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target > nums[mid]) {
				start = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
					rightIndex = mid;
					break;
				} else {
					start = mid + 1;
				}
			}
		}
		return new int[] { leftIndex, rightIndex };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] nums1 = {};
		System.out.println("The starting and ending positions of target in this array is: "
				+ Arrays.toString(searchRange(nums, 8)));
		System.out.println("The starting and ending positions of target in this array is: "
				+ Arrays.toString(searchRange(nums, 6)));
		System.out.println("The starting and ending positions of target in this array is: "
				+ Arrays.toString(searchRange(nums1, 0)));
	}

}
