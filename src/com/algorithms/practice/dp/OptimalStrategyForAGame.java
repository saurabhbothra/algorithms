package com.algorithms.practice.dp;

public class OptimalStrategyForAGame {

	// You are given an array A of size N. The array contains integers and is of
	// even length. The elements of the array represent N coin of values V1, V2,
	// ....Vn. You play against an opponent in an alternating way.

	// In each turn, a player selects either the first or last coin from the row,
	// removes it from the row permanently, and receives the value of the coin.

	// You need to determine the maximum possible amount of money you can win if you
	// go first.

	// Note: Both the players are playing optimally.

	// simple recursive solution.
	public int countMaximumSimple(int arr[]) {
		return countMaxRec(arr, 0, arr.length - 1, true);
	}

	public int countMaxRec(int[] arr, int start, int end, boolean isTurn) {
		if (start == end) {
			return 0;
		}
		if (!isTurn) {
			return Math.min(countMaxRec(arr, start + 1, end, true), countMaxRec(arr, start, end - 1, true));
		}
		return Math.max(arr[start] + countMaxRec(arr, start + 1, end, false),
				arr[end] + countMaxRec(arr, start, end - 1, false));
	}

	// memoization.
	public int countMaximumMemo(int[] arr) {
		Integer[][] memo = new Integer[arr.length][arr.length];
		return countMaxRec(arr, 0, arr.length - 1, true, memo);
	}

	public int countMaxRec(int[] arr, int start, int end, boolean isTurn, Integer[][] memo) {
		if (start == end) {
			memo[start][end] = 0;
		}
		if (memo[start][end] == null) {
			if (!isTurn) {
				memo[start][end] = Math.min(countMaxRec(arr, start + 1, end, true, memo),
						countMaxRec(arr, start, end - 1, true, memo));
			} else {
				memo[start][end] = Math.max(arr[start] + countMaxRec(arr, start + 1, end, false, memo),
						arr[end] + countMaxRec(arr, start, end - 1, false, memo));
			}
		}
		return memo[start][end];
	}

	// tabulation.
	public int countMaximumTabulation(int[] arr, int n) {
		int[][] dp = new int[n][n];
		int start = 0;
		int end = start + 1;
		int step = 1;
		while (step < n) {
			if (step % 2 != 0) {
				dp[start][end] = Math.max(arr[start] + dp[start + 1][end], arr[end] + dp[start][end - 1]);
			} else {
				dp[start][end] = Math.min(dp[start + 1][end], dp[start][end - 1]);
			}
			end++;
			start++;
			if (end == n) {
				start = 0;
				step++;
				end = start + step;
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimalStrategyForAGame os = new OptimalStrategyForAGame();
		int[] arr = { 5, 3, 7, 10 };
		System.out.println("Player1 can collect maximum coins: " + os.countMaximumSimple(arr));
		System.out.println("Player1 can collect maximum coins: " + os.countMaximumMemo(arr));
		System.out.println("Player1 can collect maximum coins: " + os.countMaximumTabulation(arr, arr.length));
	}

}
