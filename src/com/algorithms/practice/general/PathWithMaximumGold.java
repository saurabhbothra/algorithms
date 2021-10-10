package com.algorithms.practice.general;

public class PathWithMaximumGold {

	// In a gold mine grid of size m x n, each cell in this mine has an integer
	// representing the amount of gold in that cell, 0 if it is empty.

	// Return the maximum amount of gold you can collect under the conditions:

	// Every time you are located in a cell you will collect all the gold in that
	// cell.
	// From your position, you can walk one step to the left, right, up, or down.
	// You can't visit the same cell more than once.
	// Never visit a cell with 0 gold.
	// You can start and stop collecting gold from any position in the grid that has
	// some gold.

	// dfs with backtracking.
	private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static int getMaximumGold(int[][] grid) {
		int maxGoldCollected = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != 0) {
					maxGoldCollected = Math.max(maxGoldCollected, dfs(grid, i, j));
				}
			}
		}
		return maxGoldCollected;
	}

	private static int dfs(int[][] grid, int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
			return 0;
		}
		int maxGold = 0;
		int temp = grid[r][c];
		grid[r][c] = 0;
		for (int i = 0; i < directions.length; i++) {
			int newRow = r + directions[i][0];
			int newCol = c + directions[i][1];
			int subResult = temp + dfs(grid, newRow, newCol);
			maxGold = Math.max(maxGold, subResult);
		}
		grid[r][c] = temp;
		return maxGold;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		System.out.println("Maximum gold collected is: " + getMaximumGold(grid));
	}

}
