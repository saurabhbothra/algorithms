package com.algorithms.practice.general;

import java.util.Arrays;

public class GameOfLife {

	// The board is made up of an m x n grid of cells, where each cell has an
	// initial state: live (represented by a 1) or dead (represented by a 0). Each
	// cell interacts with its eight neighbors (horizontal, vertical, diagonal)
	// using the following four rules (taken from the above Wikipedia article):

	// Any live cell with fewer than two live neighbors dies as if caused by
	// under-population.

	// Any live cell with two or three live neighbors lives on to the next
	// generation.

	// Any live cell with more than three live neighbors dies, as if by
	// over-population.

	// Any dead cell with exactly three live neighbors becomes a live cell, as if by
	// reproduction.

	// The next state is created by applying the above rules simultaneously to every
	// cell in the current state, where births and deaths occur simultaneously.
	// Given the current state of the m x n grid board, return the next state.

	// Follow up:

	// Could you solve it in-place? Remember that the board needs to be updated
	// simultaneously: You cannot update some cells first and then use their updated
	// values to update other cells.
	// In this question, we represent the board using a 2D array. In principle, the
	// board is infinite, which would cause problems when the active area encroaches
	// upon the border of the array (i.e., live cells reach the border). How would
	// you address these problems?

	private static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { -1, 1 },
			{ 1, -1 } };

	// using space.
	public static void gameOfLifeSpace(int[][] board) {
		int[][] result = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				validate(board, result, i, j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = result[i][j];
			}
		}
	}

	private static void validate(int[][] board, int[][] result, int row, int col) {
		int liveNeighbors = 0;
		for (int i = 0; i < directions.length; i++) {
			int newRow = row + directions[i][0];
			int newCol = col + directions[i][1];
			if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
					&& board[newRow][newCol] == 1) {
				liveNeighbors++;
			}
		}
		if (board[row][col] == 1) {
			if (liveNeighbors == 2 || liveNeighbors == 3) {
				result[row][col] = 1;
			}
		} else {
			if (liveNeighbors == 3) {
				result[row][col] = 1;
			}
		}
	}

	// without space.
	public static void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				validate(board, i, j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 2) {
					board[i][j] = 0;
				} else if (board[i][j] == 3) {
					board[i][j] = 1;
				}
			}
		}
	}

	private static void validate(int[][] board, int row, int col) {
		int liveNeighbors = 0;
		for (int i = 0; i < directions.length; i++) {
			int newRow = row + directions[i][0];
			int newCol = col + directions[i][1];
			if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
					&& (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)) {
				liveNeighbors++;
			}
		}
		if (board[row][col] == 1) {
			if (liveNeighbors < 2 || liveNeighbors > 3) {
				board[row][col] = 2;
			}
		} else {
			if (liveNeighbors == 3) {
				board[row][col] = 3;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);
		for (int[] row : board) {
			System.out.println(Arrays.toString(row));
		}
	}

}
