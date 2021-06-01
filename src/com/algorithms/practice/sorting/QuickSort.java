package com.algorithms.practice.sorting;

import java.util.Arrays;

public class QuickSort {

	// Implement quick sort algorithm.

	// lomuto partition.
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

	// hoare partition.
	public static int hoarePartition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l - 1;
		int j = h + 1;
		int index = 0;
		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);
			if (i >= j) {
				index = j;
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return index;
	}

	// efficient solution.
	public static void quickSortUsingLomuto(int[] arr, int l, int h) {
		if (l < h) {
			int pivotPosition = lomutoPartition(arr, l, h);
			quickSortUsingLomuto(arr, l, pivotPosition - 1);
			quickSortUsingLomuto(arr, pivotPosition + 1, h);
		}
	}

	// efficient solution.
	public static void quickSortUsingHoare(int[] arr, int l, int h) {
		if (l < h) {
			int partition = hoarePartition(arr, l, h);
			quickSortUsingHoare(arr, l, partition);
			quickSortUsingHoare(arr, partition + 1, h);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 8, 6, 2, 1, 7 };
		int[] arr1 = { 8, 4, 7, 9, 3, 10, 5 };
		quickSortUsingLomuto(arr, 0, arr.length - 1);
		quickSortUsingHoare(arr1, 0, arr1.length - 1);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
		System.out.println("The array after sorting is: " + Arrays.toString(arr1));
	}

}
