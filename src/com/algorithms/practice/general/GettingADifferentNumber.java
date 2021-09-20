package com.algorithms.practice.general;

import java.util.HashSet;
import java.util.Set;

public class GettingADifferentNumber {

	// Given an array arr of unique nonnegative integers, implement a function
	// getDifferentNumber that finds the smallest nonnegative integer that is NOT in
	// the array.

	// Your algorithm should be efficient, both from a time and a space complexity
	// perspectives.

	// Solve first for the case when you’re NOT allowed to modify the input arr. If
	// successful and still have time, see if you can come up with an algorithm with
	// an improved space complexity when modifying arr is allowed. Do so without
	// trading off the time complexity.

	// Analyze the time and space complexities of your algorithm.

	// solution without space.
	public static int getDifferentNumber(int[] arr) {
		// your code goes here
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			while (temp != i && temp < n) {
				arr[i] = arr[arr[i]];
				arr[temp] = temp;
				temp = arr[i];
			}
		}

		int result = -1;
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] != i) {
				result = i;
				break;
			}
		}
		return (result == -1) ? i : result;
	}

	// solution with space.
	public static int getDifferentNumberSpace(int[] arr) {
		Set<Integer> hset = new HashSet<>();
		for (int i : arr) {
			hset.add(i);
		}
		int n = arr.length;
		int i = 0;
		int result = n;
		for (i = 0; i < n; i++) {
			if (!hset.contains(i)) {
				return i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 45, 0, 2, 1, 4, 5, 3 };
		System.out.println(getDifferentNumberSpace(arr));
	}

}
