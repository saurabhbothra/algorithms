package com.algorithms.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

	// implement bubble sort algorithm.

	// efficient solution.
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 10, 8, 7 };
		bubbleSort(arr);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
	}

}
