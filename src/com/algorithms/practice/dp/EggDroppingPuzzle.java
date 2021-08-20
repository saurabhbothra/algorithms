package com.algorithms.practice.dp;

public class EggDroppingPuzzle {

	// You are given N identical eggs and you have access to a K-floored building
	// from 1 to K.

	// There exists a floor f where 0 <= f <= K such that any egg dropped at a floor
	// higher than f will break, and any egg dropped at or below floor f will not
	// break. There are few rules given below.

	// An egg that survives a fall can be used again.
	// A broken egg must be discarded.
	// The effect of a fall is the same for all eggs.
	// If the egg doesn't break at a certain floor, it will not break at any floor
	// below.
	// If the eggs breaks at a certain floor, it will break at any floor above.

	// Return the minimum number of moves that you need to determine with certainty
	// what the value of f is.

	// simple recursive solution.
	public int eggDropSimple(int n, int k) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		if (k == 0 || k == 1) {
			return k;
		}
		int minMoves = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			int noBreakMoves = eggDropSimple(n, k - i);
			int breakMoves = eggDropSimple(n - 1, i - 1);
			minMoves = Math.min(minMoves, Math.max(noBreakMoves, breakMoves));
		}
		return 1 + minMoves;
	}

	// memoization.
	public int eggDropMemo(int n, int k) {
		Integer[][] memo = new Integer[k + 1][n + 1];
		return eggDropRec(n, k, memo);
	}

	public int eggDropRec(int n, int k, Integer[][] memo) {
		if (n == 0) {
			memo[k][n] = 0;
		}
		if (n == 1) {
			memo[k][n] = k;
		}
		if (k == 0 || k == 1) {
			memo[k][n] = k;
		}
		if (memo[k][n] == null) {
			int minMoves = Integer.MAX_VALUE;
			for (int i = 1; i <= k; i++) {
				int noBreakMoves = eggDropRec(n, k - i, memo);
				int breakMoves = eggDropRec(n - 1, i - 1, memo);
				minMoves = Math.min(minMoves, Math.max(noBreakMoves, breakMoves));
			}
			memo[k][n] = 1 + minMoves;
		}
		return memo[k][n];
	}

	// tabulation.
	public int eggDropTabulation(int n, int k) {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EggDroppingPuzzle ed = new EggDroppingPuzzle();
		System.out.println("The minimum number of moves needed are: " + ed.eggDropSimple(1, 2));
		System.out.println("The minimum number of moves needed are: " + ed.eggDropMemo(1, 2));
		System.out.println("The minimum number of moves needed are: " + ed.eggDropTabulation(1, 2));
	}

}
