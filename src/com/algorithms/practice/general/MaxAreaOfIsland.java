package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class MaxAreaOfIsland {

	// You are given an m x n binary matrix grid. An island is a group of 1's
	// (representing land) connected 4-directionally (horizontal or vertical.) You
	// may assume all four edges of the grid are surrounded by water.

	// The area of an island is the number of cells with a value 1 in the island.

	// Return the maximum area of an island in grid. If there is no island, return
	// 0.

	// dfs solution.
	public int maxAreaOfIslandDfs(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		return maxArea;
	}

	private int dfs(int[][] grid, int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
			return 0;
		}
		grid[r][c] = 0;
		return 1 + dfs(grid, r, c + 1) + dfs(grid, r, c - 1) + dfs(grid, r + 1, c) + dfs(grid, r - 1, c);
	}

	// bfs solution.
	public int maxAreaOfIslandBfs(int[][] grid) {
		int maxArea = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int area = bfs(grid, i, j, q);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		return maxArea;
	}

	private int bfs(int[][] grid, int r, int c, ArrayDeque<int[]> q) {
		q.offer(new int[] { r, c });
		grid[r][c] = 0;
		int count = 0;
		while (!q.isEmpty()) {
			int[] popped = q.poll();
			int row = popped[0];
			int col = popped[1];
			count++;
			if (row - 1 >= 0 && grid[row - 1][col] != 0) {
				grid[row - 1][col] = 0;
				q.offer(new int[] { row - 1, col });
			}

			if (row + 1 < grid.length && grid[row + 1][col] != 0) {
				grid[row + 1][col] = 0;
				q.offer(new int[] { row + 1, col });
			}

			if (col - 1 >= 0 && grid[row][col - 1] != 0) {
				grid[row][col - 1] = 0;
				q.offer(new int[] { row, col - 1 });
			}

			if (col + 1 < grid[row].length && grid[row][col + 1] != 0) {
				grid[row][col + 1] = 0;
				q.offer(new int[] { row, col + 1 });
			}

		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxAreaOfIsland ms = new MaxAreaOfIsland();
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int[][] grid1 = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println("The max area of island is: " + ms.maxAreaOfIslandDfs(grid));
		System.out.println("The max area of island is: " + ms.maxAreaOfIslandBfs(grid1));
	}

}
