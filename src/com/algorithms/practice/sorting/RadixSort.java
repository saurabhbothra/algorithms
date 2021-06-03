package com.algorithms.practice.sorting;

import java.util.Arrays;

public class RadixSort {

	// Implement radix sort algorithm.

	// efficient solution.
	public static void radixSort(int[] arr) {
		int maxValue = Arrays.stream(arr).max().getAsInt();
		for (int exp = 1; maxValue / exp > 0; exp = exp * 10) {
			countingSort(arr, exp);
		}
	}

	// helper method for doing counting sort.
	public static void countingSort(int[] arr, int exp) {
		int[] frequency = new int[10];
		int[] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			frequency[(arr[i] / exp) % 10] = frequency[(arr[i] / exp) % 10] + 1;
		}
		for (int i = 1; i < 10; i++) {
			frequency[i] = frequency[i] + frequency[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			output[frequency[(arr[i] / exp) % 10] - 1] = arr[i];
			frequency[(arr[i] / exp) % 10] = frequency[(arr[i] / exp) % 10] - 1;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 319, 212, 6, 8, 100, 50 };
		radixSort(arr);
		System.out.println("The array after sorting is: " + Arrays.toString(arr));
	}

}
