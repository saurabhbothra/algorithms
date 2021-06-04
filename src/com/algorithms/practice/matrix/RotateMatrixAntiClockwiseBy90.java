package com.algorithms.practice.matrix;

public class RotateMatrixAntiClockwiseBy90 {

	// Given an n cross n matrix, we wish to rotate the matrix anti clockwise by 90
	// degrees.

	// naive solution
	public static int[][] rotateMatrixAntiClockwiseBy90Naive(int[][] arr) {
		int[][] output = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			int index = 0;
			for (int j = 0; j < arr[i].length; j++) {
				output[i][j] = arr[index][arr[i].length - 1 - i];
				index++;
			}
		}
		return output;
	}

	// efficient solution
	public static int[][] rotateMatrixAntiClockwiseBy90(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int left = 0;
			int right = arr[i].length - 1;
			while (left < right) {
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				left++;
				right--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		return arr;
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
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("The rotated matrix is: ");
		displayMatrix(rotateMatrixAntiClockwiseBy90(arr));
		System.out.println();
		System.out.println("The rotated matrix is: ");
		displayMatrix(rotateMatrixAntiClockwiseBy90(arr1));
	}

}
