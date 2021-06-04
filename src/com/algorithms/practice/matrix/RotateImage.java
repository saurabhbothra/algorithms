package com.algorithms.practice.matrix;

public class RotateImage {

	// You are given an n x n 2D matrix representing an image, rotate the image by
	// 90 degrees (clockwise).

	// You have to rotate the image in-place, which means you have to modify the
	// input 2D matrix directly. DO NOT allocate another 2D matrix and do the
	// rotation.

	// efficient solution.
	public static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			int left = 0;
			int right = matrix[i].length - 1;
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
	}

	// helper method to display matrix.
	public static void displayMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(arr1);
		System.out.println("The rotated matrix is: ");
		displayMatrix(arr1);
	}

}
