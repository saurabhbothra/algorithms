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

	public int[] playerRows;
	public int[] playerCols;
	public int diag;
	public int antiDiag;
	public int n;

	public TicTacToe(int n) {
		this.playerRows = new int[n];
		this.playerCols = new int[n];
		this.diag = 0;
		this.antiDiag = 0;
		this.n = n;
	}

	public int move(int row, int col, int player) {
		int result = 0;
		if (player == 1) {
			playerRows[row] += 1;
			playerCols[col] += 1;
			if (row == col) {
				diag++;
			}
			if (col == n - row - 1) {
				antiDiag++;
			}
			if (playerRows[row] == n || playerCols[col] == n || diag == n || antiDiag == n) {
				result = 1;
			}
		} else {
			playerRows[row] -= 1;
			playerCols[col] -= 1;
			if (row == col) {
				diag--;
			}
			if (col == n - row - 1) {
				antiDiag--;
			}
			if (playerRows[row] == -n || playerCols[col] == -n || diag == -n || antiDiag == -n) {
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
