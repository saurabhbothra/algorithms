package com.algorithms.practice.general;

public class InterleavingString {

	// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
	// s1 and s2.

	// An interleaving of two strings s and t is a configuration where they are
	// divided into non-empty substrings such that:

	// s = s1 + s2 + ... + sn
	// t = t1 + t2 + ... + tm
	// |n - m| <= 1
	// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 +
	// t3 + s3 + ...
	// Note: a + b is the concatenation of strings a and b.

	// Follow up: Could you solve it using only O(s2.length) additional memory
	// space?

	// 0 <= s1.length, s2.length <= 100
	// 0 <= s3.length <= 200
	// s1, s2, and s3 consist of lowercase English letters.

	// simple recursive solution.
	public boolean isInterleaveSimple(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		return interleaveRec(s1, s2, s3, s1.length(), s2.length(), s3.length());
	}

	private boolean interleaveRec(String s1, String s2, String s3, int i, int j, int k) {
		if (k == 0) {
			return true;
		}
		boolean flag1 = false;
		boolean flag2 = false;
		if (i != 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
			flag1 = interleaveRec(s1, s2, s3, i - 1, j, k - 1);
		}
		if (j != 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
			flag2 = interleaveRec(s1, s2, s3, i, j - 1, k - 1);
		}
		return flag1 || flag2;
	}

	// memoization.
	public boolean isInterleaveMemo(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
		return interleaveRec(s1, s2, s3, s1.length(), s2.length(), s3.length(), memo);
	}

	private boolean interleaveRec(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
		if (k == 0) {
			memo[i][j] = true;
		}
		if (memo[i][j] == null) {
			boolean flag1 = false;
			boolean flag2 = false;
			if (i != 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
				flag1 = interleaveRec(s1, s2, s3, i - 1, j, k - 1, memo);
			}
			if (j != 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
				flag2 = interleaveRec(s1, s2, s3, i, j - 1, k - 1, memo);
			}
			memo[i][j] = flag1 || flag2;
		}
		return memo[i][j];
	}

	// tabulation.
	public boolean isInterleaveTabulation(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				boolean flag1 = false;
				boolean flag2 = false;
				if (i != 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					flag1 = dp[i - 1][j];
				}
				if (j != 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					flag2 = dp[i][j - 1];
				}
				dp[i][j] = flag1 || flag2;
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString is = new InterleavingString();
		System.out.println(
				"Is s3 formed by interleaving of s1 and s2: " + is.isInterleaveSimple("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(
				"Is s3 formed by interleaving of s1 and s2: " + is.isInterleaveMemo("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println("Is s3 formed by interleaving of s1 and s2: "
				+ is.isInterleaveTabulation("aabcc", "dbbca", "aadbbcbcac"));
	}

}
