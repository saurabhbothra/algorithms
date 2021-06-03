package com.algorithms.practice.matrix;

public class MatrixInSnakePattern {

	// Given a matrix, our task is to print matrix in snake pattern.

	// efficient solution.
	public static void printMatrixInSnakePattern(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i % 2 == 0) {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print(arr[i][arr[i].length - 1 - j] + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("The matrix in snake pattern is: ");
		printMatrixInSnakePattern(arr);
		System.out.println();
		printMatrixInSnakePattern(arr1);
	}

}
