package com.algorithms.practice.general;

import java.util.ArrayDeque;

public class SurroundedRegions {

	// Given an m x n matrix board containing 'X' and 'O', capture all regions that
	// are 4-directionally surrounded by 'X'.

	// A region is captured by flipping all 'O's into 'X's in that surrounded
	// region.

	// dfs solution.
	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][board[i].length - 1] == 'O') {
				dfs(board, i, board[i].length - 1);
			}
		}

		for (int i = 1; i < board[0].length - 1; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}
			if (board[board.length - 1][i] == 'O') {
				dfs(board, board.length - 1, i);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void dfs(char[][] board, int r, int c) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
			return;
		}
		board[r][c] = '.';
		dfs(board, r, c + 1);
		dfs(board, r + 1, c);
		dfs(board, r - 1, c);
		dfs(board, r, c - 1);
	}

	// bfs solution.
	public void solveBfs(char[][] board) {
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				q.offer(new int[] { i, 0 });
				board[i][0] = '.';
			}
			if (board[i][board[i].length - 1] == 'O') {
				q.offer(new int[] { i, board[i].length - 1 });
				board[i][board[i].length - 1] = '.';
			}
		}

		for (int i = 1; i < board[0].length - 1; i++) {
			if (board[0][i] == 'O') {
				q.offer(new int[] { 0, i });
				board[0][i] = '.';
			}
			if (board[board.length - 1][i] == 'O') {
				q.offer(new int[] { board.length - 1, i });
				board[board.length - 1][i] = '.';
			}
		}

		while (!q.isEmpty()) {
			int[] stats = q.poll();
			int r = stats[0];
			int c = stats[1];
			for (int i = 0; i < directions.length; i++) {
				int nr = r + directions[i][0];
				int nc = c + directions[i][1];
				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[r].length && board[nr][nc] == 'O') {
					q.offer(new int[] { nr, nc });
					board[nr][nc] = '.';
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}

			}
		}
	}

}
