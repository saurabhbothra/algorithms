package com.algorithms.practice.sorting;

import java.util.concurrent.ThreadLocalRandom;

public class KthLargestElement {

	// Given an integer array nums and an integer k, return the kth largest element
	// in the array.

	// Note that it is the kth largest element in the sorted order, not the kth
	// distinct element.

	// efficient solution, quick-select algorithm with randomization.
	public static int findKthLargest(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		int result = -1;
		while (start <= end) {
			int randIndex = ThreadLocalRandom.current().nextInt(start, end + 1);
			int p = lomutoPartition(nums, start, end, randIndex);
			if (p == (nums.length - k)) {
				result = nums[p];
				break;
			} else if (p > (nums.length - k)) {
				end = p - 1;
			} else {
				start = p + 1;
			}
		}
		return result;
	}

	// helper method for doing lomuto partition with randomization.
	public static int lomutoPartition(int[] nums, int start, int end, int pivotIndex) {
		int temp = nums[end];
		nums[end] = nums[pivotIndex];
		nums[pivotIndex] = temp;
		int pivotElement = nums[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (nums[j] < pivotElement) {
				i++;
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		i++;
		temp = nums[i];
		nums[i] = pivotElement;
		nums[end] = temp;
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 1, 5, 6, 4 };
		int[] arr1 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println("The kth smallest element in this array is: " + findKthLargest(arr, 2));
		System.out.println("The kth smallest element in this array is: " + findKthLargest(arr1, 4));
	}

}
