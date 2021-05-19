package com.algorithms.practice.arrays;

public class LongestEvenOddSubarray {

	// Given an array, find out length of longest sub array that has alternating odd
	// even elements.

	public static int findOddEvenMaxLength(int[] arr) {
		int maxCount = 1;
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i-1] % 2 == 0 && arr[i] % 2 != 0) || (arr[i-1] % 2 != 0 && arr[i] % 2 == 0)) {
				count++;
				maxCount = Math.max(maxCount, count);
			} else {
				count = 1;
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 12, 14, 7, 8 };
		int[] arr1 = { 7, 10, 13, 14 };
		int[] arr2 = { 10, 12, 8, 4 };
		System.out.println("The maximum length of subarray is: " + findOddEvenMaxLength(arr));
		System.out.println("The maximum length of subarray is: " + findOddEvenMaxLength(arr1));
		System.out.println("The maximum length of subarray is: " + findOddEvenMaxLength(arr2));
	}

}
