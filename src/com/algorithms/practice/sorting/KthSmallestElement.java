package com.algorithms.practice.sorting;

public class KthSmallestElement {

	// Given an unsorted array, and a number k, we need to find out kth smallest
	// element.

	// efficient solution, quick select algorithm.
	public static int kSmallestElement(int[] arr, int k) {
		int result = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int p = lomutoPartition(arr, start, end);
			if (p == k - 1) {
				result = arr[k - 1];
				break;
			} else if (p > k - 1) {
				end = p - 1;
			} else {
				start = p + 1;
			}
		}
		return result;
	}

	// helper method for lomuto partition.
	public static int lomutoPartition(int[] arr, int l, int h) {
		int pivot = arr[h];
		int i = l - 1;
		for (int j = l; j < h; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[h];
		arr[h] = temp;
		return i;
	}

	// solution using randomization.
	public static int kthSmallest(int nums[], int k) {
		// Your code here
		int start = 0;
		int end = nums.length - 1;
		int result = -1;
		while (start <= end) {
			int randIndex = (int) ((Math.random() * (end + 1 - start)) + start);
			int pivotIndex = partition(nums, start, end, randIndex);
			if (pivotIndex == k - 1) {
				result = nums[pivotIndex];
				break;
			} else if (pivotIndex > k - 1) {
				end = pivotIndex - 1;
			} else {
				start = pivotIndex + 1;
			}
		}
		return result;
	}

	private static int partition(int[] nums, int start, int end, int in) {
		int temp = nums[end];
		nums[end] = nums[in];
		nums[in] = temp;
		int pivotElement = nums[end];
		int index = start - 1;
		for (int i = start; i < end; i++) {
			if (nums[i] < pivotElement) {
				index++;
				temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
		}
		index++;
		temp = nums[index];
		nums[index] = nums[end];
		nums[end] = temp;
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 30, 20, 5, 10, 8 };
		int[] arr1 = { 10, 5, 30, 12 };
		System.out.println("The kth smallest element in this array is: " + kSmallestElement(arr, 4));
		System.out.println("The kth smallest element in this array is: " + kthSmallest(arr1, 2));
	}

}
