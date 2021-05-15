package com.algorithms.practice.arrays;

public class LargestElement {

	// Given an array, find out the index of the largest element.

	public static int findLargestElementIndex(int[] arr) {
		int maxElementIndex = -1;
		int maxElement = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxElement) {
				maxElement = arr[i];
				maxElementIndex = i;
			}
		}
		return maxElementIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 40, 8, 5, 100 };
		System.out.println("The index of the largest element in the array is: " + findLargestElementIndex(arr));
	}

}
