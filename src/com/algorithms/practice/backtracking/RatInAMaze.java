package com.algorithms.practice.backtracking;

public class RatInAMaze {

	// Given a binary matrix which represents a maze. O values in this matrix are
	// blocked cells. 1 values in this matrix are cells through which rat can go.
	// In this maze, there is a rat at top left corner and there is a cheese at
	// bottom right corner. Rat has to collect the cheese and it can go through only
	// unblocked cells.
	// When rat is at cell (i, j), it can make only two moves: cell (i + 1, j) and
	// cell (i, j + 1).
	// Our goal is to check if a path exists for the rat to collect the cheese.

	// efficient implementation.
	public static boolean isPathExist(int[][] maze) {
		int[][] path = new int[maze.length][maze[0].length];
		if (!mazeBacktrack(maze, 0, 0, path)) {
			return false;
		}
		System.out.println();
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[i].length; j++) {
				System.out.print(path[i][j]);
			}
			System.out.println();
		}
		return true;
	}

	public static boolean mazeBacktrack(int[][] maze, int row, int column, int[][] path) {
		if (row == maze.length - 1 && column == maze[row].length - 1) {
			path[row][column] = 1;
			return true;
		}
		if (isSafe(maze, row, column)) {
			path[row][column] = 1;
			if (mazeBacktrack(maze, row + 1, column, path)) {
				return true;
			} else if (mazeBacktrack(maze, row, column + 1, path)) {
				return true;
			}
			path[row][column] = 0;
		}
		return false;
	}

	public static boolean isSafe(int[][] maze, int r, int c) {
		if (r == maze.length || c == maze[r].length || maze[r][c] == 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 }, };
		int[][] maze1 = { { 1, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, };
		System.out.println("Can rat collect the cheese: " + isPathExist(maze));
		System.out.println("Can rat collect the cheese: " + isPathExist(maze1));
	}

}
