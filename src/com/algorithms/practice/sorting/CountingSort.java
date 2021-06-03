package com.algorithms.practice.sorting;

import java.util.Arrays;

public class CountingSort {

	// Implement counting sort algorithm.

	// naive solution, can only be used for sorting integers.
	public static void countingSort(int[] arr, int k) {
		int[] frequency = new int[k];
		for (int i = 0; i < arr.length; i++) {
			frequency[arr[i]] = frequency[arr[i]] + 1;
		}
		int index = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < frequency[i]; j++) {
				arr[index] = i;
				index++;
			}
		}
	}

	// efficient solution, general purpose algorithm.
	public static void countingSortEfficient(int[] arr, int k) {
		int[] frequency = new int[k];
		int[] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			frequency[arr[i]] = frequency[arr[i]] + 1;
		}
		for (int i = 1; i < frequency.length; i++) {
			frequency[i] = frequency[i - 1] + frequency[i];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			output[frequency[arr[i]] - 1] = arr[i];
			frequency[arr[i]] = frequency[arr[i]] - 1;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	// efficient solution, k not given.
	public static void countingSortWithoutK(int[] arr) {
		int maxValue = Arrays.stream(arr).max().getAsInt();
		int minValue = Arrays.stream(arr).min().getAsInt();
		int range = maxValue - minValue + 1;
		int[] frequency = new int[range];
		int[] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			frequency[arr[i] - minValue] = frequency[arr[i] - minValue] + 1;
		}
		for (int i = 1; i < range; i++) {
			frequency[i] = frequency[i] + frequency[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			output[frequency[arr[i] - minValue] - 1] = arr[i];
			frequency[arr[i] - minValue] = frequency[arr[i] - minValue] - 1;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 4, 1, 0, 1 };
		int[] arr1 = { 2, 1, 8, 9, 4 };
		int[] arr2 = { -5, -10, 0, -3, 8, 5, -1, 10 };
		countingSort(arr1, 10);
		countingSortEfficient(arr, 5);
		countingSortWithoutK(arr2);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
		System.out.println("The array after sorting is: " + Arrays.toString(arr1));
		System.out.println("The array after sorting is: " + Arrays.toString(arr2));
	}

}
