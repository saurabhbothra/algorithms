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

	// simple recursive solution.
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

	// memoization solution.
	public static int longestCommonSubsequenceMemo(String text1, String text2) {
		return 0;
	}

	// tabulation solution.
	public static int longestCommonSubsequenceTabulation(String text1, String text2) {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde";
		String text2 = "ace";
		System.out
				.println("The length of longest common subsequence is: " + longestCommonSubsequenceNaive(text1, text2));
	}

}
