package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class RottenOranges {

	// You are given an m x n grid where each cell can have one of three values:

	// 0 representing an empty cell,
	// 1 representing a fresh orange, or
	// 2 representing a rotten orange.

	// Every minute, any fresh orange that is 4-directionally adjacent to a rotten
	// orange becomes rotten.

	// Return the minimum number of minutes that must elapse until no cell has a
	// fresh orange. If this is impossible, return -1.

	// bfs solution.
	public int orangesRotting(int[][] grid) {
		int count = 0;
		int onesCount = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
				if (grid[i][j] == 1) {
					onesCount++;
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			if (onesCount == 0) {
				break;
			}
			for (int i = 0; i < size; i++) {
				int[] poppedIndex = q.poll();
				int r = poppedIndex[0];
				int c = poppedIndex[1];
				grid[r][c] = 0;
				if (r - 1 >= 0 && grid[r - 1][c] == 1) {
					grid[r - 1][c] = 2;
					onesCount--;
					q.offer(new int[] { r - 1, c });
				}

				if (r + 1 < grid.length && grid[r + 1][c] == 1) {
					grid[r + 1][c] = 2;
					onesCount--;
					q.offer(new int[] { r + 1, c });
				}

				if (c - 1 >= 0 && grid[r][c - 1] == 1) {
					grid[r][c - 1] = 2;
					onesCount--;
					q.offer(new int[] { r, c - 1 });
				}

				if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
					grid[r][c + 1] = 2;
					onesCount--;
					q.offer(new int[] { r, c + 1 });
				}
			}
			count++;
		}
		return (onesCount == 0) ? count : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RottenOranges ro = new RottenOranges();
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("The number of minutes it will take is: " + ro.orangesRotting(grid));
	}

}
