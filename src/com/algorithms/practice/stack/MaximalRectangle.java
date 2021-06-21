package com.algorithms.practice.stack;

import java.util.ArrayDeque;

public class MaximalRectangle {

	// Given a rows x cols binary matrix filled with 0's and 1's, find the largest
	// rectangle containing only 1's and return its area.

	// efficient solution.
	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] heights = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '1') {
					heights[j] = heights[j] + 1;
				} else {
					heights[j] = 0;
				}
			}
			int area = largestRectangleArea(heights);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	// helper method to find largest rectangular area in a histogram.
	private static int largestRectangleArea(int[] heights) {
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

}
