package com.algorithms.practice;

public class demo {

	public static boolean isSubarrayWithGivenSum(int[] arr, int sum) {
		int currSum = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum = currSum + arr[i];
			while (index <= i && currSum > sum) {
				currSum = currSum - arr[index];
				index++;
			}
			if (currSum == sum) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		int[] arr1 = { 1, 4, 0, 0, 3, 10, 5 };
		int[] arr2 = { 2, 4 };
		System.out.println("Is subarray with given sum: " + isSubarrayWithGivenSum(arr, 33));
		System.out.println("Is subarray with given sum: " + isSubarrayWithGivenSum(arr1, 7));
		System.out.println("Is subarray with given sum: " + isSubarrayWithGivenSum(arr2, 3));
	}
}
