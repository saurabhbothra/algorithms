package com.algorithms.practice.dp;

public class MinimumPathSum {

	// Given a m x n grid filled with non-negative numbers, find a path from top
	// left to bottom right, which minimizes the sum of all numbers along its path.

	// Note: You can only move either down or right at any point in time.

	// tabulation.
	public static int minPathSum(int[][] grid) {
		int[][] cost = new int[grid.length][grid[0].length];
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[i].length - 1; j >= 0; j--) {
				int rightSum = (j + 1 == grid[i].length) ? -1 : cost[i][j + 1];
				int bottomSum = (i + 1 == grid.length) ? -1 : cost[i + 1][j];
				if (rightSum != -1 && bottomSum != -1) {
					cost[i][j] = grid[i][j] + Math.min(rightSum, bottomSum);
				} else if (rightSum == -1 && bottomSum == -1) {
					cost[i][j] = grid[i][j];
				} else {
					cost[i][j] = grid[i][j] + Math.max(rightSum, bottomSum);
				}

			}
		}
		return cost[0][0];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println("The minimum path sum is: " + minPathSum(grid));
	}

}
