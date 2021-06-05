package com.algorithms.practice.matrix;

public class SearchInRowwiseAndColumnWiseSortedMatrix {

	// Write an efficient algorithm that searches for a target value in an m x n
	// integer matrix. The matrix has the following properties:

	// Integers in each row are sorted in ascending from left to right.
	// Integers in each column are sorted in ascending from top to bottom.

	// efficient solution.
	public static boolean searchMatrixEfficient(int[][] matrix, int target) {
		int rowIndex = matrix.length - 1;
		int colIndex = 0;
		while (rowIndex >= 0 && colIndex <= matrix[rowIndex].length - 1) {
			if (matrix[rowIndex][colIndex] == target) {
				return true;
			}
			if (matrix[rowIndex][colIndex] < target) {
				colIndex++;
			} else {
				rowIndex--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println("Is given element found: " + searchMatrixEfficient(matrix, 5));
		System.out.println("Is given element found: " + searchMatrixEfficient(matrix, 20));
	}

}
