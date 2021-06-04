package com.algorithms.practice.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversalOfMatrix {

	// Given an m x n matrix, return all elements of the matrix in spiral order.

	// efficient solution.
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralOrderList = new ArrayList<>();
		int rowTop = 0;
		int rowBottom = matrix.length - 1;
		int colLeft = 0;
		int colRight = matrix[0].length - 1;
		while (rowTop <= rowBottom && colLeft <= colRight) {
			for (int i = colLeft; i <= colRight; i++) {
				spiralOrderList.add(matrix[rowTop][i]);
			}
			if (rowTop == rowBottom) {
				break;
			}
			for (int i = rowTop + 1; i <= rowBottom; i++) {
				spiralOrderList.add(matrix[i][colRight]);
			}
			if (colLeft == colRight) {
				break;
			}
			for (int i = colRight - 1; i >= colLeft; i--) {
				spiralOrderList.add(matrix[rowBottom][i]);
			}
			for (int i = rowBottom - 1; i > rowTop; i--) {
				spiralOrderList.add(matrix[i][colLeft]);
			}
			rowTop++;
			rowBottom--;
			colLeft++;
			colRight--;
		}
		return spiralOrderList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("The elements in spiral form are: " + Arrays.toString((spiralOrder(arr)).toArray()));
	}

}
