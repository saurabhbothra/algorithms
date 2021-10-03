package com.algorithms.practice.general;

public class LongestIncreasingPathInAMatrix {

	// Given an m x n integers matrix, return the length of the longest increasing
	// path in matrix.

	// From each cell, you can either move in four directions: left, right, up, or
	// down. You may not move diagonally or move outside the boundary (i.e.,
	// wrap-around is not allowed).

	// 0 <= matrix[i][j] <= 231 - 1

	// naive solution.
	private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPathSimple(int[][] matrix) {
		int maxLength = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				maxLength = Math.max(maxLength, dfs(matrix, i, j, -1));
			}
		}
		return maxLength;
	}

	private int dfs(int[][] matrix, int r, int c, int prev) {
		if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] == -1
				|| matrix[r][c] <= prev) {
			return 0;
		}

		int maxLength = 1;
		int temp = matrix[r][c];
		matrix[r][c] = -1;
		for (int i = 0; i < directions.length; i++) {
			int subResult = dfs(matrix, r + directions[i][0], c + directions[i][1], temp);
			maxLength = Math.max(maxLength, 1 + subResult);
		}
		matrix[r][c] = temp;
		return maxLength;
	}

	// memoization.
	public int longestIncreasingPathMemo(int[][] matrix) {
		int maxLength = 1;
		Integer[][] memo = new Integer[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				maxLength = Math.max(maxLength, dfs(matrix, i, j, -1, memo));
			}
		}
		return maxLength;
	}

	private int dfs(int[][] matrix, int r, int c, int prev, Integer[][] memo) {
		if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length || matrix[r][c] == -1
				|| matrix[r][c] <= prev) {
			return 0;
		}
		if (memo[r][c] == null) {
			int maxLength = 1;
			int temp = matrix[r][c];
			matrix[r][c] = -1;
			for (int i = 0; i < directions.length; i++) {
				int subResult = dfs(matrix, r + directions[i][0], c + directions[i][1], temp, memo);
				maxLength = Math.max(maxLength, 1 + subResult);
			}
			matrix[r][c] = temp;
			memo[r][c] = maxLength;
		}
		return memo[r][c];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPathInAMatrix lis = new LongestIncreasingPathInAMatrix();
		int[][] matrix = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
		System.out.println("Length of longest increasing path is: " + lis.longestIncreasingPathSimple(matrix));
		System.out.println("Length of longest increasing path is: " + lis.longestIncreasingPathMemo(matrix));
	}

}
