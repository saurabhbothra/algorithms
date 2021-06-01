package com.algorithms.practice.sorting;

import java.util.Arrays;

public class ChocolateDistributionProblem {

	// Given chocolate packets of different sizes in an array, and there are m
	// children, distribute
	// the packets to these m children based on the following rules:

	// Every child should get exactly one chocolate.
	// Minimize the difference between minimum chocolates a child gets and maximum
	// chocolates another child gets.

	// efficient solution.
	public static int chocolateDistribution(int[] arr, int m) {
		if (m >= arr.length || m <= 1) {
			return -1;
		}
		int result = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 0; i <= arr.length - m; i++) {
			int difference = arr[i + m - 1] - arr[i];
			result = Math.min(result, difference);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
		int[] arr1 = { 3, 4, 1, 9, 56, 7, 9, 12 };
		System.out.println("The minimum difference is: " + chocolateDistribution(arr, 3));
		System.out.println("The minimum difference is: " + chocolateDistribution(arr1, 5));
	}

}
