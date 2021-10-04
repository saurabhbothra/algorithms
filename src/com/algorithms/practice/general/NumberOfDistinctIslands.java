package com.algorithms.practice.general;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

	// You are given an m x n binary matrix grid. An island is a group of 1's
	// (representing land) connected 4-directionally (horizontal or vertical.) You
	// may assume all four edges of the grid are surrounded by water.

	// An island is considered to be the same as another if and only if one island
	// can be translated (and not rotated or reflected) to equal the other.

	// Return the number of distinct islands.

	// dfs solution.
	public int numDistinctIslands(int[][] grid) {
		Set<String> hmap = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder code = new StringBuilder();
					dfs(grid, i, j, code, i, j);
					hmap.add(code.toString());
				}
			}
		}
		return hmap.size();
	}

	private void dfs(int[][] grid, int r, int c, StringBuilder code, int nr, int nc) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
			return;
		}
		code.append(r - nr);
		code.append(c - nc);
		grid[r][c] = 0;
		dfs(grid, r, c + 1, code, nr, nc);
		dfs(grid, r, c - 1, code, nr, nc);
		dfs(grid, r + 1, c, code, nr, nc);
		dfs(grid, r - 1, c, code, nr, nc);

	}

}
