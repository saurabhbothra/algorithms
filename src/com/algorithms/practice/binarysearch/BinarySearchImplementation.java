package com.algorithms.practice.binarysearch;

public class BinarySearchImplementation {

	// implementation of binary search, both recursive and iterative.

	// Given a sorted array and an element to be searched in this array, find the
	// index of this element if it is present.
	// If element not present, return -1.
	// If there are multiple occurrences of this element, we need to return index of
	// any of its occurrences.

	// iterative solution.
	public static int binarySearchIterative(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	// recursive solution.
	public static int binarySearchRecursive(int[] nums, int target) {
		return binarySearchRec(nums, target, 0, nums.length - 1);
	}

	// helper method for binary search recursive.
	private static int binarySearchRec(int[] nums, int target, int start, int end) {
		int mid = (start + end) / 2;
		if (end < start) {
			return -1;
		}
		if (target == nums[mid]) {
			return mid;
		}
		if (target < nums[mid]) {
			return binarySearchRec(nums, target, start, mid - 1);
		} else {
			return binarySearchRec(nums, target, mid + 1, end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50 };
		int[] arr1 = { 5, 15, 25 };
		int[] arr2 = { 5, 10, 15, 25, 35 };
		int[] arr3 = { 10, 15 };
		int[] arr4 = { 10, 10 };
		System.out.println("Is element present in this array: " + binarySearchIterative(arr, 20));
		System.out.println("Is element present in this array: " + binarySearchIterative(arr1, 25));
		System.out.println("Is element present in this array: " + binarySearchIterative(arr2, 20));
		System.out.println("Is element present in this array: " + binarySearchIterative(arr3, 20));
		System.out.println("Is element present in this array: " + binarySearchIterative(arr3, 5));
		System.out.println("Is element present in this array: " + binarySearchIterative(arr4, 10));
		System.out.println();
		System.out.println("Is element present in this array: " + binarySearchRecursive(arr, 20));
		System.out.println("Is element present in this array: " + binarySearchRecursive(arr1, 25));
		System.out.println("Is element present in this array: " + binarySearchRecursive(arr2, 20));
		System.out.println("Is element present in this array: " + binarySearchRecursive(arr3, 20));
		System.out.println("Is element present in this array: " + binarySearchRecursive(arr3, 5));
		System.out.println("Is element present in this array: " + binarySearchRecursive(arr4, 10));
	}

}
