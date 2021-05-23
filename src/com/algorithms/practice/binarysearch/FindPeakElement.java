package com.algorithms.practice.binarysearch;

public class FindPeakElement {

	// A peak element is an element that is strictly greater than its neighbors.

	// Given an integer array nums, find a peak element, and return its index. If
	// the array contains multiple peaks, return the index to any of the peaks.

	// You may imagine that nums[-1] = nums[n] = -∞.
	// 1 <= nums.length <= 1000

	// efficient solution, binary search.
	public static int findPeakElement(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1])) {
				return mid;
			}
			if (mid != nums.length - 1 && nums[mid + 1] > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 1 };
		System.out.println("The index of peak element in this array is: " + findPeakElement(nums));
	}

}
