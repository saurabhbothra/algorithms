package com.algorithms.practice.matrix;

public class MatrixBoundaryTraversal {

	// Given a matrix, print boundary elements of this matrix.

	// efficient solution.
	public static void printBoundaryElements(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0) {
					System.out.print(arr[i][j] + " ");
				} else if (i == arr.length - 1) {
					System.out.print(arr[i][arr[i].length - 1 - j] + " ");
				} else {
					System.out.print(arr[i][arr[i].length - 1] + " ");
					break;
				}
			}
		}
		for (int i = arr.length - 2; i >= 1; i--) {
			if(arr[i].length != 1) {
				System.out.print(arr[i][0] + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] arr1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		int[][] arr2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int[][] arr3 = { { 1, 2, 3, 4 } };
		System.out.println("The boundary elements of the matrix are: ");
		printBoundaryElements(arr);
		System.out.println();
		printBoundaryElements(arr1);
		System.out.println();
		printBoundaryElements(arr2);
		System.out.println();
		printBoundaryElements(arr3);
	}

}
