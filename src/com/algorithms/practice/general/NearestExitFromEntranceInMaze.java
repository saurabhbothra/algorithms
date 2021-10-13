package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class NearestExitFromEntranceInMaze {

	// You are given an m x n matrix maze (0-indexed) with empty cells (represented
	// as '.') and walls (represented as '+'). You are also given the entrance of
	// the maze, where entrance = [entrancerow, entrancecol] denotes the row and
	// column of the cell you are initially standing at.

	// In one step, you can move one cell up, down, left, or right. You cannot step
	// into a cell with a wall, and you cannot step outside the maze. Your goal is
	// to find the nearest exit from the entrance. An exit is defined as an empty
	// cell that is at the border of the maze. The entrance does not count as an
	// exit.

	// Return the number of steps in the shortest path from the entrance to the
	// nearest exit, or -1 if no such path exists.

	// entrance will always be an empty cell.

	private static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// bfs solution.
	public static int nearestExit(char[][] maze, int[] entrance) {
		int distance = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(entrance);
		maze[entrance[0]][entrance[1]] = '+';
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				int[] popped = q.poll();
				int row = popped[0];
				int col = popped[1];
				if ((row == 0 || row == maze.length - 1 || col == 0 || col == maze[0].length - 1)
						&& (row != entrance[0] || col != entrance[1])) {
					return distance;
				}
				for (int i = 0; i < directions.length; i++) {
					int newRow = row + directions[i][0];
					int newCol = col + directions[i][1];
					if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
							&& maze[newRow][newCol] == '.') {
						maze[newRow][newCol] = '+';
						q.offer(new int[] { newRow, newCol });
					}
				}

			}
			distance++;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
		System.out.println("The nearest distance of exit is: " + nearestExit(maze, new int[] { 1, 2 }));
	}

}
