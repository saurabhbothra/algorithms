package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class ShortestPathToGetFood {

	// You are starving and you want to eat food as quickly as possible. You want to
	// find the shortest path to arrive at any food cell.

	// You are given an m x n character matrix, grid, of these different types of
	// cells:

	// '*' is your location. There is exactly one '*' cell.
	// '#' is a food cell. There may be multiple food cells.
	// 'O' is free space, and you can travel through these cells.
	// 'X' is an obstacle, and you cannot travel through these cells.

	// You can travel to any adjacent cell north, east, south, or west of your
	// current location if there is not an obstacle.

	// Return the length of the shortest path for you to reach any food cell. If
	// there is no path for you to reach food, return -1.

	// solution using bfs.
	public static int getFood(char[][] grid) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int distance = 0;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int sourceR = 0;
		int sourceC = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '*') {
					sourceR = i;
					sourceC = j;
					break;
				}
			}
		}
		q.offer(new int[] { sourceR, sourceC });
		grid[sourceR][sourceC] = 'X';
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				int[] poppedIndex = q.poll();
				int r = poppedIndex[0];
				int c = poppedIndex[1];
				for (int i = 0; i < directions.length; i++) {
					int newR = r + directions[i][0];
					int newC = c + directions[i][1];
					if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[r].length
							&& grid[newR][newC] != 'X') {
						if (grid[newR][newC] == '#') {
							return distance + 1;
						} else {
							grid[newR][newC] = 'X';
							q.offer(new int[] { newR, newC });
						}
					}
				}
			}
			distance++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', '0', '0', '0', 'X' },
				{ 'X', '0', '0', '#', '0', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X' } };
		System.out.println("The shortest path to get food is: " + getFood(grid));
	}

}
