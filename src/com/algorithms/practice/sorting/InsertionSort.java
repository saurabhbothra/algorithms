package com.algorithms.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

	// Implement insertion sort algorithm.

	// efficient solution.
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;

			}
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 5, 40, 60, 10, 30 };
		insertionSort(arr);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
	}

}
