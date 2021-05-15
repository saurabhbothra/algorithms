package com.algorithms.practice.arrays;

public class CheckArraySorted {

	// Given an array, check if it is sorted or not in ascending order.

	// efficient solution.
	public static boolean isArraySorted(int[] arr) {
		if (arr.length == 1) {
			return true;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 12, 15 };
		int[] arr1 = { 100 };
		int[] arr2 = { 100, 20, 200 };
		int[] arr3 = { 8, 10, 10, 12 };
		System.out.println("Is given array sorted: " + isArraySorted(arr));
		System.out.println("Is given array sorted: " + isArraySorted(arr1));
		System.out.println("Is given array sorted: " + isArraySorted(arr2));
		System.out.println("Is given array sorted: " + isArraySorted(arr3));
	}

}
