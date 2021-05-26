package com.algorithms.practice.sorting;

import java.util.Arrays;

public class SelectionSort {

	// Implement selection sort algorithm.

	// efficient solution.
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 5, 8, 20, 2, 18 };
		selectionSort(arr);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
	}

}
