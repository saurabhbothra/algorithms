package com.algorithms.practice.binarysearch;

import java.util.Arrays;

public class TwoSumSorted {

	// Given an array of integers numbers that is already sorted in non-decreasing
	// order, find two numbers such that they add up to a specific target number.

	// Return the indices of the two numbers (1-indexed) as an integer array answer
	// of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

	// The tests are generated such that there is exactly one solution. You may not
	// use the same element twice.
	// 2 <= numbers.length <= 3 * 10^4

	// efficient solution, two pointers approach.
	public static int[] twoSum(int[] numbers, int target) {
		int leftIndex = -1;
		int rightIndex = -1;
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				leftIndex = start + 1;
				rightIndex = end + 1;
				break;
			}
			if (sum > target) {
				end--;
			} else {
				start++;
			}
		}
		return new int[] { leftIndex, rightIndex };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 2, 3, 4 };
		System.out.println("The indices which matches the target are: " + Arrays.toString(twoSum(numbers, 6)));
	}

}
