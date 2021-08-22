package com.algorithms.practice.graph;

public class NumberOfIslands {

	// Given an m x n 2D binary grid grid which represents a map of '1's (land) and
	// '0's (water), return the number of islands.

	// An island is surrounded by water and is formed by connecting adjacent lands
	// horizontally or vertically. You may assume all four edges of the grid are all
	// surrounded by water.

	// dfs solution.
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	public void dfs(char[][] grid, int row, int col) {
		if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0') {
			return;
		}
		grid[row][col] = '0';
		dfs(grid, row, col - 1);
		dfs(grid, row, col + 1);
		dfs(grid, row - 1, col);
		dfs(grid, row + 1, col);
	}

}
