package com.algorithms.practice.general;

import java.util.Arrays;

public class MaximumAreaOfCake {

	// You are given a rectangular cake of size h x w and two arrays of integers
	// horizontalCuts and verticalCuts where:

	// horizontalCuts[i] is the distance from the top of the rectangular cake to the
	// ith horizontal cut and similarly, and

	// verticalCuts[j] is the distance from the left of the rectangular cake to the
	// jth vertical cut.

	// Return the maximum area of a piece of cake after you cut at each horizontal
	// and vertical position provided in the arrays horizontalCuts and verticalCuts.
	// Since the answer can be a large number, return this modulo 109 + 7.

	// 2 <= h, w <= 109
	// 1 <= horizontalCuts.length <= min(h - 1, 105)
	// 1 <= verticalCuts.length <= min(w - 1, 105)
	// 1 <= horizontalCuts[i] < h
	// 1 <= verticalCuts[i] < w
	// All the elements in horizontalCuts are distinct.
	// All the elements in verticalCuts are distinct.

	// solution using sorting and greedy approach.
	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		long maxHeightDiff = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[horizontalCuts.length - 1]);
		long maxWidthDiff = Math.max(verticalCuts[0] - 0, w - verticalCuts[verticalCuts.length - 1]);
		for (int i = 1; i < horizontalCuts.length; i++) {
			maxHeightDiff = Math.max(maxHeightDiff, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		for (int i = 1; i < verticalCuts.length; i++) {
			maxWidthDiff = Math.max(maxWidthDiff, verticalCuts[i] - verticalCuts[i - 1]);
		}
		return (int) ((maxHeightDiff * maxWidthDiff) % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] horizontalCuts = { 1, 2, 4 };
		int[] verticalCuts = { 1, 3 };
		System.out.println("The maximum area of cake is: " + maxArea(5, 4, horizontalCuts, verticalCuts));
	}

}
