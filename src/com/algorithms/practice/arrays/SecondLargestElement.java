package com.algorithms.practice.arrays;

public class SecondLargestElement {

	// Given an array, find the index of second largest element in array. If there
	// is no second largest element, return -1.

	// efficient solution, single traversal of array.
	public static int findSecondLargestIndex(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		int maxIndex = 0;
		int secondMaxIndex = -1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[maxIndex]) {
				if (arr[i] > arr[maxIndex]) {
					secondMaxIndex = maxIndex;
					maxIndex = i;
				} else {
					if (secondMaxIndex == -1 || arr[i] > arr[secondMaxIndex]) {
						secondMaxIndex = i;
					}
				}
			}
		}
		return secondMaxIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 20, 10, 20, 8, 12 };
		int[] arr1 = { 10, 10, 10 };
		int[] arr2 = { 10, 5, 8, 20 };
		System.out.println("The index of second largest element in an array is: " + findSecondLargestIndex(arr));
		System.out.println("The index of second largest element in an array is: " + findSecondLargestIndex(arr1));
		System.out.println("The index of second largest element in an array is: " + findSecondLargestIndex(arr2));
	}

}
