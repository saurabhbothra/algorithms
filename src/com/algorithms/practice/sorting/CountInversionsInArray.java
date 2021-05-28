package com.algorithms.practice.sorting;

public class CountInversionsInArray {

	// Given an array, count inversions in it.
	// An inversion is a pair (arr[i], arr[j]) when i < j and arr[i] > arr[j].

	// effcient solution.
	public static int countInversions(int[] arr, int low, int high) {
		if (low == high) {
			return 0;
		}
		int mid = low + (high - low) / 2;
		int leftCount = countInversions(arr, low, mid);
		int rightCount = countInversions(arr, mid + 1, high);
		return leftCount + rightCount + countWhileMerge(arr, low, mid, high);
	}

	public static int countWhileMerge(int[] arr, int low, int mid, int high) {
		int count = 0;
		int[] left = new int[mid - low + 1];
		int[] right = new int[high - mid];

		for (int i = 0; i < left.length; i++) {
			left[i] = arr[low + i];
		}

		for (int i = 0; i < right.length; i++) {
			right[i] = arr[mid + i + 1];
		}
		int pointer1 = 0;
		int pointer2 = 0;
		int temp = low;
		while (pointer1 < left.length && pointer2 < right.length) {
			if (left[pointer1] <= right[pointer2]) {
				arr[temp] = left[pointer1];
				pointer1++;
			} else {
				arr[temp] = right[pointer2];
				pointer2++;
				count = count + (left.length - pointer1);
			}
			temp++;
		}

		while (pointer1 < left.length) {
			arr[temp] = left[pointer1];
			pointer1++;
			temp++;
		}

		while (pointer2 < right.length) {
			arr[temp] = right[pointer2];
			pointer2++;
			temp++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 4, 1, 3, 5 };
		int[] arr1 = { 10, 20, 30, 40, 50 };
		int[] arr2 = { 40, 30, 20, 10 };
		System.out.println("The number of inversions for this array is: " + countInversions(arr, 0, arr.length - 1));
		System.out.println("The number of inversions for this array is: " + countInversions(arr1, 0, arr1.length - 1));
		System.out.println("The number of inversions for this array is: " + countInversions(arr2, 0, arr2.length - 1));
	}

}
