package com.algorithms.practice.binarysearch;

public class SearchInSortedRotatedArray {

	// There is an integer array nums sorted in ascending order (with distinct
	// values).

	// Prior to being passed to your function, nums is rotated at an unknown pivot
	// index k (0 <= k < nums.length) such that the resulting array is [nums[k],
	// nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
	// example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become
	// [4,5,6,7,0,1,2].

	// Given the array nums after the rotation and an integer target, return the
	// index of target if it is in nums, or -1 if it is not in nums.
	// 1 <= nums.length <= 5000

	// efficient solution, binary search.
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] >= nums[start]) {
				if (target <= nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target >= nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums1 = { 1 };
		System.out.println("Is element present in this array: " + search(nums, 0));
		System.out.println("Is element present in this array: " + search(nums, 3));
		System.out.println("Is element present in this array: " + search(nums1, 0));
	}

}
