package com.algorithms.practice.graph;

import java.util.ArrayDeque;

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

	// bfs solution.
	public int numIslandsBfs(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					bfs(grid, i, j, new ArrayDeque<>());
				}
			}
		}
		return count;
	}

	public void bfs(char[][] grid, int row, int col, ArrayDeque<Integer[]> q) {
		q.offer(new Integer[] { row, col });
		grid[row][col] = '0';
		while (!q.isEmpty()) {
			Integer[] popIndex = q.poll();
			int r = popIndex[0];
			int c = popIndex[1];
			if (c - 1 >= 0 && grid[r][c - 1] == '1') {
				q.offer(new Integer[] { r, c - 1 });
				grid[r][c - 1] = '0';
			}
			if (c + 1 < grid[0].length && grid[r][c + 1] == '1') {
				q.offer(new Integer[] { r, c + 1 });
				grid[r][c + 1] = '0';
			}
			if (r - 1 >= 0 && grid[r - 1][c] == '1') {
				q.offer(new Integer[] { r - 1, c });
				grid[r - 1][c] = '0';
			}
			if (r + 1 < grid.length && grid[r + 1][c] == '1') {
				q.offer(new Integer[] { r + 1, c });
				grid[r + 1][c] = '0';
			}
		}
	}

}
