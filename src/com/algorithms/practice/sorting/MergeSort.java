package com.algorithms.practice.sorting;

import java.util.Arrays;

public class MergeSort {

	// Implement merge sort algorithm.

	// efficient solution.
	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	// merge process of merge sort.
	public static void merge(int[] arr, int low, int mid, int high) {
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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 5, 60, 40, 10, 30 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
	}

}
