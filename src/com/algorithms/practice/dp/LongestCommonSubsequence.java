package com.algorithms.practice.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {

	// Given two strings text1 and text2, return the length of their longest common
	// subsequence. If there is no common subsequence, return 0.

	// A subsequence of a string is a new string generated from the original string
	// with some characters (can be none) deleted without changing the relative
	// order of the remaining characters.

	// For example, "ace" is a subsequence of "abcde".

	// A common subsequence of two strings is a subsequence that is common to both
	// strings.

	// text1 and text2 consist of only lowercase English characters.

	// simple recursive solution 1.
	public static int longestCommonSubsequenceNaive(String text1, String text2) {
		int maxLength = 0;
		Set<String> hset1 = new HashSet<>();
		Set<String> hset2 = new HashSet<>();
		subSequenceRec(text1, hset1, 0, "");
		subSequenceRec(text2, hset2, 0, "");
		for (String text : hset1) {
			if (hset2.contains(text)) {
				maxLength = Math.max(maxLength, text.length());
			}
		}
		return maxLength;
	}

	// helper method to find subsequences.
	public static void subSequenceRec(String text, Set<String> hset, int level, String res) {
		if (level == text.length()) {
			hset.add(res);
			return;
		}
		subSequenceRec(text, hset, level + 1, res);
		subSequenceRec(text, hset, level + 1, res + text.charAt(level));
	}

	// simple recursive solution 2.
	public static int longestCommonSubsequenceNaiveDp(String text1, String text2) {
		return subSequenceRec(text1, text2, text1.length() - 1, text2.length() - 1);
	}

	// helper method to do recursion.
	public static int subSequenceRec(String text1, String text2, int l1, int l2) {
		if (l1 < 0 || l2 < 0) {
			return 0;
		}
		if (text1.charAt(l1) == text2.charAt(l2)) {
			return 1 + subSequenceRec(text1, text2, l1 - 1, l2 - 1);
		}
		return Math.max(subSequenceRec(text1, text2, l1 - 1, l2), subSequenceRec(text1, text2, l1, l2 - 1));
	}

	// memoization solution.
	public static int longestCommonSubsequenceMemo(String text1, String text2) {
		int[][] memo = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				memo[i][j] = -1;
			}
		}
		return subSequenceRec(text1, text2, text1.length(), text2.length(), memo);
	}

	public static int subSequenceRec(String text1, String text2, int l1, int l2, int[][] memo) {
		if (l1 == 0 || l2 == 0) {
			memo[l1][l2] = 0;
			return 0;
		}
		if (memo[l1][l2] == -1) {
			int res = 0;
			if (text1.charAt(l1 - 1) == text2.charAt(l2 - 1)) {
				res = 1 + subSequenceRec(text1, text2, l1 - 1, l2 - 1, memo);
			} else {
				res = Math.max(subSequenceRec(text1, text2, l1 - 1, l2, memo),
						subSequenceRec(text1, text2, l1, l2 - 1, memo));
			}
			memo[l1][l2] = res;
		}
		return memo[l1][l2];
	}

	// tabulation solution.
	public static int longestCommonSubsequenceTabulation(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[text1.length()][text2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde";
		String text2 = "ace";
		System.out
				.println("The length of longest common subsequence is: " + longestCommonSubsequenceTabulation(text1, text2));
	}

}
