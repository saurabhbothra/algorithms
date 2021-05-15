package com.algorithms.practice.arrays;

import java.util.Arrays;

public class ReverseArray {

	// Given an array, reverse it, modify the same array.

	// efficient solution.
	public static void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
		System.out.print(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 5, 7, 30, 20, 5 };
		System.out.print("The reversed array is: ");
		reverseArray(arr);
	}

}
