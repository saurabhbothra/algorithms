package com.algorithms.practice.sorting;

import java.util.Arrays;

public class SortArrayWithThreeTypesOfElements {

	// Sort an array with three types of elements.

	// sort an array of 0's, 1's and 2's.
	public static void sortThreeTypesOne(int[] nums) {
		int i = -1;
		int x = nums.length - 1;
		int pivot = 1;
		while (nums[x] > pivot) {
			x--;
		}
		for (int k = 0; k <= x; k++) {
			if (nums[k] > pivot) {
				int temp = nums[x];
				nums[x] = nums[k];
				nums[k] = temp;
				x--;
			}
			if (nums[k] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[k];
				nums[k] = temp;
			}
		}
	}

	// three way partitioning.
	public static void sortThreeTypesTwo(int[] nums, int pivot) {
		int i = -1;
		int x = nums.length - 1;
		while (nums[x] > pivot) {
			x--;
		}
		for (int k = 0; k <= x; k++) {
			if (nums[k] > pivot) {
				int temp = nums[x];
				nums[x] = nums[k];
				nums[k] = temp;
				x--;
			}
			if (nums[k] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[k];
				nums[k] = temp;
			}
		}
	}

	// partition around a range.
	public static void sortThreeTypesThree(int[] nums, int[] range) {
		int i = -1;
		int x = nums.length - 1;
		int lowRangeIndex = -1;
		int highRangeIndex = -1;
		while (nums[x] > range[1]) {
			x--;
		}
		for (int k = 0; k <= x; k++) {
			if (nums[k] > range[1]) {
				int temp = nums[x];
				nums[x] = nums[k];
				nums[k] = temp;
				x--;
			}
			if (nums[k] < range[0]) {
				i++;
				int temp = nums[i];
				nums[i] = nums[k];
				nums[k] = temp;
			}
			if (nums[k] == range[0]) {
				lowRangeIndex = k;
			}
			if (nums[k] == range[1]) {
				highRangeIndex = k;
			}
		}
		i++;
		int temp = nums[lowRangeIndex];
		nums[lowRangeIndex] = nums[i];
		nums[i] = temp;

		temp = nums[x];
		nums[x] = nums[highRangeIndex];
		nums[highRangeIndex] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 0, 1, 2, 2, 1, 0, 1 };
		int[] arr2 = { 2, 1, 2, 20, 10, 20, 1 };
		int[] arr3 = { 10, 5, 6, 3, 20, 9, 40 };
		sortThreeTypesOne(arr1);
		sortThreeTypesTwo(arr2, 2);
		sortThreeTypesThree(arr3, new int[] { 5, 10 });
		System.out.println("The sorted array is: " + Arrays.toString(arr1));
		System.out.println("The sorted array is: " + Arrays.toString(arr2));
		System.out.println("The sorted array is: " + Arrays.toString(arr3));
	}

}
