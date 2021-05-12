package com.algorithms.practice.recursion;

public class RopeCutting {

	// Given a rope of length n, cut this rope into maximum number of pieces, such
	// that every piece has length either as a, b, or c.
	// Length of every piece after cuts should be in set [a, b, c].
	// 0 <= a, b, c <= n

	public static int findMaxPieces(int n, int a, int b, int c) {
		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return -1;
		}
		int aCount = findMaxPieces(n - a, a, b, c);
		int bCount = findMaxPieces(n - b, a, b, c);
		int cCount = findMaxPieces(n - c, a, b, c);
		int maxCount = Math.max(aCount, Math.max(bCount, cCount));
		if (maxCount < 0) {
			return -1;
		}
		return 1 + maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("We can cut maximum pieces equal to: " + findMaxPieces(5, 2, 5, 1));
	}

}
