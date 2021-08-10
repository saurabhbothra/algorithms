package com.algorithms.practice.dp;

public class FibonacciNumber {

	// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
	// Fibonacci sequence, such that each number is the sum of the two preceding
	// ones, starting from 0 and 1.

	// F(0) = 0, F(1) = 1
	// F(n) = F(n - 1) + F(n - 2), for n > 1.
	// Given n, calculate F(n).
	// 0 <= n <= 30

	// simple plain recursive solution.
	public static int fibSimple(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibSimple(n - 1) + fibSimple(n - 2);
	}

	// memoization solution.
	public static int fibMemoization(int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}
		fibMemo(n, memo);
		return memo[n];
	}

	// helper method for memoization.
	public static void fibMemo(int n, int[] memo) {
		if (n <= 1) {
			memo[n] = n;
			return;
		}
		if (memo[n - 1] == -1) {
			fibMemo(n - 1, memo);
		}
		if (memo[n - 2] == -1) {
			fibMemo(n - 2, memo);
		}
		memo[n] = memo[n - 1] + memo[n - 2];
	}

	// tabulation solution.
	public static int fibTabulation(int n) {
		if (n <= 1) {
			return n;
		}
		int[] table = new int[n + 1];
		table[0] = 0;
		table[1] = 1;
		for (int i = 2; i <= n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}
		return table[n];
	}

	// tabulation solution using constant space.
	public static int fibTabulationSecond(int n) {
		if (n <= 1) {
			return n;
		}
		int a = 0;
		int b = 1;
		int temp = 0;
		for (int i = 2; i <= n; i++) {
			int c = a + b;
			a = b;
			b = c;
			temp = c;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println("The nth fibonacci number is: " + fibTabulation(n));
	}

}
