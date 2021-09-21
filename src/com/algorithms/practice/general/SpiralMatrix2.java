package com.algorithms.practice.general;

import java.util.Arrays;

public class SpiralMatrix2 {

	// Given a positive integer n, generate an n x n matrix filled with elements
	// from 1 to n2 in spiral order.

	// efficient solution.
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int a = 1;
		int topRow = 0;
		int bottomRow = n - 1;
		int topCol = 0;
		int bottomCol = n - 1;
		while (topRow <= bottomRow && topCol <= bottomCol) {
			for (int i = topCol; i <= bottomCol; i++) {
				matrix[topRow][i] = a++;
			}
			for (int i = topRow + 1; i <= bottomRow; i++) {
				matrix[i][bottomCol] = a++;
			}
			if (bottomRow == topRow || topCol == bottomCol) {
				break;
			}
			for (int i = bottomCol - 1; i >= topCol; i--) {
				matrix[bottomRow][i] = a++;
			}
			for (int i = bottomRow - 1; i > topRow; i--) {
				matrix[i][topCol] = a++;
			}
			topRow++;
			bottomRow--;
			topCol++;
			bottomCol--;
		}
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = generateMatrix(3);
		for (int[] i : matrix) {
			System.out.println(Arrays.toString(i));
		}
	}

}
