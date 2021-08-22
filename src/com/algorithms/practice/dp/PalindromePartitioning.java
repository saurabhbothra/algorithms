package com.algorithms.practice.dp;

public class PalindromePartitioning {

	// Given a string s, partition s such that every substring of the partition is a
	// palindrome.

	// Return the minimum cuts needed for a palindrome partitioning of s.

	// s consists of lower-case English letters only.

	// simple recursive solution.
	public int minCutSimple(String s) {
		return minCutRec(s, 0, s.length() - 1);
	}

	public int minCutRec(String s, int i, int j) {
		if (isPalindrome(s, i, j)) {
			return 0;
		}
		int minimumCuts = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			if (isPalindrome(s, i, k)) {
				int subResult = 1 + minCutRec(s, k + 1, j);
				minimumCuts = Math.min(minimumCuts, subResult);
			}
		}
		return minimumCuts;
	}

	public boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// memoization.
	public int minCutMemo(String s) {
		Integer[][] memo = new Integer[s.length()][s.length()];
		Boolean[][] isPal = new Boolean[s.length()][s.length()];
		return minCutRec(s, 0, s.length() - 1, memo, isPal);
	}

	public int minCutRec(String s, int i, int j, Integer[][] memo, Boolean[][] isPal) {
		if (isPalindrome(s, i, j, isPal)) {
			memo[i][j] = 0;
		} else {
			isPal[i][j] = false;
		}
		if (memo[i][j] == null) {
			int minimumCuts = Integer.MAX_VALUE;
			for (int k = i; k < j; k++) {
				if (isPalindrome(s, i, k, isPal)) {
					isPal[i][k] = true;
					int subResult = 1 + minCutRec(s, k + 1, j, memo, isPal);
					minimumCuts = Math.min(minimumCuts, subResult);
				} else {
					isPal[i][k] = false;
				}
			}
			memo[i][j] = minimumCuts;
		}
		return memo[i][j];
	}

	public boolean isPalindrome(String s, int start, int end, Boolean[][] isPal) {
		if (isPal[start][end] != null) {
			return isPal[start][end];
		} else if (start == end) {
			isPal[start][end] = true;
			return true;
		}
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// tabulation.
	public int minCutTabulation(String s) {
		int n = s.length();
		int[] dp = new int[n];
		boolean[][] isPal = new boolean[n][n];
		buildPalindromeDp(s, isPal);
		for (int end = 0; end < n; end++) {
			int minimumCuts = end;
			for (int start = 0; start <= end; start++) {
				if (isPal[start][end]) {
					if (start == 0) {
						minimumCuts = 0;
					} else {
						minimumCuts = Math.min(minimumCuts, 1 + dp[start - 1]);
					}
				}
			}
			dp[end] = minimumCuts;
		}
		return dp[n - 1];
	}

	public void buildPalindromeDp(String s, boolean[][] isPal) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			isPal[i][i] = true;
		}
		int start = 0;
		int end = start + 1;
		int step = 1;
		while (step < n) {
			if (s.charAt(start) != s.charAt(end)) {
				isPal[start][end] = false;
			} else {
				if (step == 1) {
					isPal[start][end] = true;
				} else {
					isPal[start][end] = isPal[start + 1][end - 1];
				}
			}
			end++;
			start++;
			if (end == n) {
				start = 0;
				step++;
				end = start + step;
			}
		}
	}

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		// TODO Auto-generated method stub
		String s = "aab";
		System.out.println("The minimum partition required is: " + pp.minCutSimple(s));
		System.out.println("The minimum partition required is: " + pp.minCutMemo(s));
		System.out.println("The minimum partition required is: " + pp.minCutTabulation(s));
	}

}
