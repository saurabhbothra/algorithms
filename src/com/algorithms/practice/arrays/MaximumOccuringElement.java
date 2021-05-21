package com.algorithms.practice.arrays;


public class MaximumOccuringElement {

	// Given n ranges, find the maximum appearing element in these ranges.
	// Assume li <= ri
	// 0 <= li[i], ri[i] < 1000

	// efficient solution.
	public static int maximumAppearingElement(int[] li, int[] ri) {
		int[] tempArr = new int[1000];
		for (int i = 0; i < li.length; i++) {
			tempArr[li[i]] += 1;
			tempArr[ri[i] + 1] -= 1;
		}
		int frequency = tempArr[0];
		int maxIndex = 0;
		for (int i = 1; i < tempArr.length; i++) {
			tempArr[i] = tempArr[i] + tempArr[i - 1];
			if (tempArr[i] > frequency) {
				frequency = tempArr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] li = { 1, 2, 5, 15 };
		int[] ri = { 5, 8, 7, 18 };
		System.out.println("The maximum appearng element in these ranges are: " + maximumAppearingElement(li, ri));
	}

}
