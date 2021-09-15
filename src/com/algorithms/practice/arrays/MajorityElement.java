package com.algorithms.practice.arrays;

public class MajorityElement {

	// Given an array nums of size n, return the majority element.

	// The majority element is the element that appears more than ⌊n / 2⌋ times. You
	// may assume that the majority element always exists in the array.
	// 1 <= n

	// solution using divide and conquer.
	public static int majorityElementDivide(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	private static int mergeSort(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = start + (end - start) / 2;
		int left = mergeSort(nums, start, mid);
		int right = mergeSort(nums, mid + 1, end);
		if (left == right) {
			return left;
		}
		int leftCount = fetchCount(nums, left, start, end);
		int rightCount = fetchCount(nums, right, start, end);
		return leftCount > rightCount ? left : right;

	}

	private static int fetchCount(int[] nums, int element, int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (nums[i] == element) {
				count++;
			}
		}
		return count;
	}

	// efficient solution, Boyer-Moore Voting Algorithm
	public static int majorityElement(int[] nums) {
		int result = 0;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[result]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				result = i;
			}
		}
		return nums[result];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println("The majority element in the given array is: " + majorityElement(nums));
		System.out.println("The majority element in the given array is: " + majorityElementDivide(nums));
	}

}
