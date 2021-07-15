package com.algorithms.practice.sorting;

import java.util.Arrays;

public class HeapSort {

	// Implement heap sort algorithm.

	// efficient solution.
	public static void heapSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		buildMaxHeap(arr, arr.length);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapify(arr, 0, i);
		}
	}

	// helper method to build max heap.
	public static void buildMaxHeap(int[] arr, int heapSize) {
		if (heapSize <= 1) {
			return;
		}
		for (int i = (heapSize - 2) / 2; i >= 0; i--) {
			maxHeapify(arr, i, heapSize);
		}
	}

	// helper method to perform max heapify operation.
	public static void maxHeapify(int[] arr, int i, int heapSize) {
		if (i >= heapSize && i < 0) {
			return;
		}
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		int temp = i;
		if (left < heapSize && arr[i] < arr[left]) {
			temp = left;
		}
		if (right < heapSize && arr[temp] < arr[right]) {
			temp = right;
		}
		if (temp == i) {
			return;
		}
		int s = arr[i];
		arr[i] = arr[temp];
		arr[temp] = s;
		maxHeapify(arr, temp, heapSize);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 5, 1, 4, 25, 60, 45 };
		heapSort(arr);
		System.out.println("The sorted array is: " + Arrays.toString(arr));
	}

}
