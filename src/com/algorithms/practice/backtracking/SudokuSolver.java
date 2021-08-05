package com.algorithms.practice.backtracking;

public class SudokuSolver {

	// Write a program to solve a Sudoku puzzle by filling the empty cells.

	// A sudoku solution must satisfy all of the following rules:

	// Each of the digits 1-9 must occur exactly once in each row.
	// Each of the digits 1-9 must occur exactly once in each column.
	// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
	// of the grid.
	// The '.' character indicates empty cells.

	// board[i][j] is a digit or '.'.
	// It is guaranteed that the input board has only one solution.

	// efficient implementation.
	public static void solveSudoku(char[][] board) {
		int[][] setMatrix = new int[3][3];
		int[][] boxes = new int[9][9];
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				setMatrix[i][j] = count;
				count++;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int digit = Integer.parseInt(Character.toString(board[i][j]));
					int index = setMatrix[i / 3][j / 3];
					boxes[index][digit - 1] = digit;
				}
			}
		}
		sodokuBacktrack(board, 0, 0, setMatrix, boxes);
	}

	public static boolean sodokuBacktrack(char[][] board, int row, int column, int[][] setMatrix, int[][] boxes) {
		if (row == 9) {
			return true;
		}
		if (board[row][column] != '.') {
			return (column == 8) ? sodokuBacktrack(board, row + 1, 0, setMatrix, boxes)
					: sodokuBacktrack(board, row, column + 1, setMatrix, boxes);
		} else {
			for (int i = 1; i <= 9; i++) {
				char d = Integer.toString(i).charAt(0);
				if (isSafe(board, row, column, d, setMatrix, boxes)) {
					board[row][column] = d;
					boolean isValid = (column == 8) ? sodokuBacktrack(board, row + 1, 0, setMatrix, boxes)
							: sodokuBacktrack(board, row, column + 1, setMatrix, boxes);
					if (isValid) {
						return true;
					}
					board[row][column] = '.';
					int index = setMatrix[row / 3][column / 3];
					boxes[index][i - 1] = 0;
				}
			}
		}
		return false;
	}

	public static boolean isSafe(char[][] board, int r, int c, char digit, int[][] setMatrix, int[][] boxes) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == digit && i != c) {
				return false;
			}
			if (board[i][c] == digit && i != r) {
				return false;
			}
		}
		int d = Character.getNumericValue(digit);
		int index = setMatrix[r / 3][c / 3];
		if (boxes[index][d - 1] == d) {
			return false;
		}
		boxes[index][d - 1] = d;
		return true;
	}

}
