package com.algorithms.practice.general;

public class TicTacToe {

	// Assume the following rules are for the tic-tac-toe game on an n x n board
	// between two players:

	// A move is guaranteed to be valid and is placed on an empty block.
	// Once a winning condition is reached, no more moves are allowed.
	// A player who succeeds in placing n of their marks in a horizontal, vertical,
	// or diagonal row wins the game.

	// Constraints:

	// 2 <= n <= 100
	// player is 1 or 2.
	// 0 <= row, col < n
	// (row, col) are unique for each different call to move.
	// At most n2 calls will be made to move.

	// Follow-up: Could you do better than O(n2) per move() operation?

	public int[] player1Rows;
	public int[] player2Rows;
	public int[] player1Cols;
	public int[] player2Cols;
	public int diag1;
	public int diag2;
	public int antiDiag1;
	public int antiDiag2;
	public int n;

	public TicTacToe(int n) {
		this.player1Rows = new int[n];
		this.player2Rows = new int[n];
		this.player1Cols = new int[n];
		this.player2Cols = new int[n];
		this.diag1 = 0;
		this.diag2 = 0;
		this.antiDiag1 = 0;
		this.antiDiag2 = 0;
		this.n = n;
	}

	public int move(int row, int col, int player) {
		int result = 0;
		if (player == 1) {
			player1Rows[row] += 1;
			player1Cols[col] += 1;
			if (row == col) {
				diag1++;
			}
			if (col == n - row - 1) {
				antiDiag1++;
			}
			if (player1Rows[row] == n || player1Cols[col] == n || diag1 == n || antiDiag1 == n) {
				result = 1;
			}
		} else {
			player2Rows[row] += 1;
			player2Cols[col] += 1;
			if (row == col) {
				diag2++;
			}
			if (col == n - row - 1) {
				antiDiag2++;
			}
			if (player2Rows[row] == n || player2Cols[col] == n || diag2 == n || antiDiag2 == n) {
				result = 2;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe ticTacToe = new TicTacToe(3);
		System.out.println(ticTacToe.move(0, 0, 1));
		System.out.println(ticTacToe.move(0, 2, 2));
		System.out.println(ticTacToe.move(2, 2, 1));
		System.out.println(ticTacToe.move(1, 1, 2));
		System.out.println(ticTacToe.move(2, 0, 1));
		System.out.println(ticTacToe.move(1, 0, 2));
		System.out.println(ticTacToe.move(2, 1, 1));

	}

}
