package com.algorithms.practice.bitmagic;

import java.util.Arrays;

public class TwoOddOccurring {

	// Given an array of integers, find two numbers that has odd occurrences in the
	// array. The array will only have two numbers that has odd occurrences.

	// efficient implementation using bit manipulation.
	public static int[] findTwoOdds(int[] nums) {
		int[] result = new int[2];
		int g1 = 0;
		int g2 = 0;
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}
		int res = xor & ~(xor - 1);
		for (int i = 0; i < nums.length; i++) {
			if ((res & nums[i]) != 0) {
				g1 = g1 ^ nums[i];
			} else {
				g2 = g2 ^ nums[i];
			}
		}
		result[0] = g1;
		result[1] = g2;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };
		int[] nums1 = { 20, 15, 20, 16 };
		System.out.println("the numbers with odd occurrences are: " + Arrays.toString(findTwoOdds(nums)));
		System.out.println("the numbers with odd occurrences are: " + Arrays.toString(findTwoOdds(nums1)));
	}

}
