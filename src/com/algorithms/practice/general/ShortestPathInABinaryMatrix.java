package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class ShortestPathInABinaryMatrix {

	// Given an n x n binary matrix grid, return the length of the shortest clear
	// path in the matrix. If there is no clear path, return -1.

	// A clear path in a binary matrix is a path from the top-left cell (i.e., (0,
	// 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

	// All the visited cells of the path are 0.

	// All the adjacent cells of the path are 8-directionally connected (i.e., they
	// are different and they share an edge or a corner).

	// The length of a clear path is the number of visited cells of this path.

	// solution using bfs.
	public static int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
			return -1;
		}
		if (grid.length == 1) {
			return 1;
		}
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
		int distance = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		grid[0][0] = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			distance++;
			for (int j = 0; j < size; j++) {
				int[] poppedIndex = q.poll();
				int r = poppedIndex[0];
				int c = poppedIndex[1];
				for (int i = 0; i < directions.length; i++) {
					int newR = r + directions[i][0];
					int newC = c + directions[i][1];
					if (newR == grid.length - 1 && newC == grid.length - 1) {
						return distance + 1;
					}
					if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid.length && grid[newR][newC] == 0) {
						grid[newR][newC] = 1;
						q.offer(new int[] { newR, newC });
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println("The shortest path in a binary matrix is: " + shortestPathBinaryMatrix(grid));
	}

}
