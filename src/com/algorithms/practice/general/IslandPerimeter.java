package com.algorithms.practice.general;

public class IslandPerimeter {

	// You are given row x col grid representing a map where grid[i][j] = 1
	// represents land and grid[i][j] = 0 represents water.

	// Grid cells are connected horizontally/vertically (not diagonally). The grid
	// is completely surrounded by water, and there is exactly one island (i.e., one
	// or more connected land cells).

	// The island doesn't have "lakes", meaning the water inside isn't connected to
	// the water around the island. One cell is a square with side length 1. The
	// grid is rectangular, width and height don't exceed 100. Determine the
	// perimeter of the island.

	// dfs implementation.
	public int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					perimeter = Math.max(perimeter, dfsRec(grid, i, j));
				}
			}
		}
		return perimeter;
	}

	private int dfsRec(int[][] grid, int r, int c) {
		grid[r][c] = -1;
		int per = 0;
		for (int i = 0; i < directions.length; i++) {
			int newRow = r + directions[i][0];
			int newCol = c + directions[i][1];
			if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[r].length
					|| grid[newRow][newCol] == 0) {
				per++;
			} else if (grid[newRow][newCol] == 1) {
				per = per + dfsRec(grid, newRow, newCol);
			}
		}
		return per;
	}

	// iterative solution.
	public int islandPerimeterIter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					for (int k = 0; k < directions.length; k++) {
						int newRow = i + directions[k][0];
						int newCol = j + directions[k][1];
						if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[i].length
								|| grid[newRow][newCol] == 0) {
							perimeter++;
						}
					}
				}
			}
		}
		return perimeter;
	}

}
