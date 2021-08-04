package com.algorithms.practice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

	// The n-queens puzzle is the problem of placing n queens on an n x n chess
	// board
	// such that no two queens attack each other.

	// Given an integer n, return all distinct solutions to the n-queens puzzle. You
	// may return the answer in any order.

	// Each solution contains a distinct board configuration of the n-queens'
	// placement, where 'Q' and '.' both indicate a queen and an empty space,
	// respectively.

	// efficient implementation.
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int[][] path = new int[n][n];
		queensBacktrack(path, 0, n, result);
		return result;
	}

	public static void queensBacktrack(int[][] path, int row, int n, List<List<String>> result) {
		if (row == n) {
			addSolution(path, result, n);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isSafe(path, row, i, n)) {
				path[row][i] = 1;
				queensBacktrack(path, row + 1, n, result);
				path[row][i] = 0;
			}
		}
	}

	public static void addSolution(int[][] path, List<List<String>> result, int n) {
		List<String> solution = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (path[i][j] == 0) {
					sb.append(".");
				} else {
					sb.append("Q");
				}
			}
			solution.add(sb.toString());
		}
		result.add(solution);
	}

	public static boolean isSafe(int[][] path, int r, int c, int n) {
		if (r == n || c == n) {
			return false;
		}
		for (int i = 0; i < r; i++) {
			if (path[i][c] == 1) {
				return false;
			}
		}
		int ru = r - 1;
		int cu = c - 1;
		while (ru >= 0 && cu >= 0) {
			if (path[ru][cu] == 1) {
				return false;
			}
			ru = ru - 1;
			cu = cu - 1;
		}
		ru = r - 1;
		cu = c + 1;
		while (ru >= 0 && cu < n) {
			if (path[ru][cu] == 1) {
				return false;
			}
			ru = ru - 1;
			cu = cu + 1;
		}
		return true;
	}

}
