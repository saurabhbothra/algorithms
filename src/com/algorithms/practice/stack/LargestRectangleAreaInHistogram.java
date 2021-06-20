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
		ArrayDeque<Integer> st = new ArrayDeque<>();
		st.push(-1);
		for (int i = 0; i < heights.length; i++) {
			while (st.peek() != -1 && heights[st.peek()] > heights[i]) {
				int poppedIndex = st.pop();
				maxArea = Math.max(maxArea, heights[poppedIndex] * (i - st.peek() - 1));
			}
			st.push(i);
		}
		while (st.peek() != -1) {
			int poppedIndex = st.pop();
			maxArea = Math.max(maxArea, heights[poppedIndex] * (heights.length - st.peek() - 1));
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 2, 5, 4, 1, 5, 6 };
		System.out.println("The maximum rectangular area is: " + largestRectangleArea(arr));
	}

}
