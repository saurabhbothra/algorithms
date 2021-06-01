package com.algorithms.practice.sorting;

import java.util.Arrays;

public class SortAnArrayWithTwoTypesOfElements {
	
	// Sort array with two types of elements.

	// Segregate positive or negative.
	public static void sortTwoTypesOne(int[] nums) {
		int i = -1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] < 0) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}

	// Segregate even and odd.
	public static void sortTwoTypesTwo(int[] nums) {
		int i = -1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] % 2 == 0) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}

	// Sort a Binary Array.
	public static void sortWithTwoTypesThree(int[] nums) {
		int i = -1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == 0) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 15, -3, -2, 18 };
		int[] arr2 = { 15, 14, 13, 12 };
		int[] arr3 = { 0, 1, 1, 1, 0 };
		sortTwoTypesOne(arr1);
		sortTwoTypesTwo(arr2);
		sortWithTwoTypesThree(arr3);
		System.out.println("The sorted array is: " + Arrays.toString(arr1));
		System.out.println("The sorted array is: " + Arrays.toString(arr2));
		System.out.println("The sorted array is: " + Arrays.toString(arr3));
	}

}
