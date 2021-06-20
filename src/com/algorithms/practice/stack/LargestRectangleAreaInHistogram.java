package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class LargestRectangleAreaInHistogram {

	// Given an array of integers heights representing the histogram's bar height
	// where the width of each bar is 1, return the area of the largest rectangle in
	// the histogram.

	// naive solution.
	public static int largestRectangleAreaNaive(int[] heights) {
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			int area = heights[i];
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] >= heights[i]) {
					area = area + heights[i];
				} else {
					break;
				}
			}
			for (int j = i + 1; j < heights.length; j++) {
				if (heights[j] >= heights[i]) {
					area = area + heights[i];
				} else {
					break;
				}
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	// best efficient solution.
	public static int largestRectangleArea(int[] heights) {
		int maxArea = Integer.MIN_VALUE;
		ArrayDeque<int[]> st = new ArrayDeque<>();
		for (int i = 0; i < heights.length; i++) {
			int lastPoppedIndex = i;
			while (!st.isEmpty() && st.peek()[0] >= heights[i]) {
				int[] poppedItem = st.pop();
				maxArea = Math.max(maxArea, poppedItem[0] * (i - poppedItem[1]));
				lastPoppedIndex = poppedItem[1];
			}
			int[] item = { heights[i], lastPoppedIndex };
			st.push(item);
		}
		while (!st.isEmpty()) {
			int[] poppedItem = st.pop();
			maxArea = Math.max(maxArea, poppedItem[0] * (heights.length - poppedItem[1]));
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 2, 5, 4, 1, 5, 6 };
		System.out.println("The maximum rectangular area is: " + largestRectangleArea(arr));
	}

}
