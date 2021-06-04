package com.algorithms.practice.matrix;

import java.util.Arrays;

public class TransposeOfMatrix {

	// Given a 2D integer array matrix, return the transpose of matrix.
	// The transpose of a matrix is the matrix flipped over its main diagonal,
	// switching the matrix's row and column indices.

	// efficient solution.
	public static int[][] transpose(int[][] matrix) {
		int[][] output = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                output[i][j] = matrix[j][i];
            }
        }
        return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println("The transpose of the matrix is: " + Arrays.toString(transpose(arr)));
		System.out.println("The transpose of the matrix is: " + Arrays.toString(transpose(arr1)));
	}

}
