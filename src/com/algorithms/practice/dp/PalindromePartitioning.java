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
		return minCutRec(s, 0, s.length() - 1, memo);
	}

	public int minCutRec(String s, int i, int j, Integer[][] memo) {
		if (isPalindrome(s, i, j)) {
			memo[i][j] = 0;
		}
		if (memo[i][j] == null) {
			int minimumCuts = Integer.MAX_VALUE;
			for (int k = i; k < j; k++) {
				if (isPalindrome(s, i, k)) {
					int subResult = 1 + minCutRec(s, k + 1, j, memo);
					minimumCuts = Math.min(minimumCuts, subResult);
				}
			}
			memo[i][j] = minimumCuts;
		}
		return memo[i][j];
	}

	// tabulation.
	public int minCutTabulation(String s) {
		return 0;
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
