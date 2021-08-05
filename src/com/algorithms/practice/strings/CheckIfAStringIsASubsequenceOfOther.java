package com.algorithms.practice.strings;

public class CheckIfAStringIsASubsequenceOfOther {

	// Given two strings s1 and s2, find out whether s2 is a subsequence of s1 or
	// not.
	// A subsequence of a string is obtained by removing 0 or more characters from
	// the string. Characters not removed from the string should be present in same
	// order in other string.

	// recursive naive solution.
	public static boolean isSubsequence(String s1, String s2) {
		return subRec(s1, s2, 0, "");
	}

	// helper method to do recursion.
	public static boolean subRec(String s1, String s2, int level, String res) {
		if (level == s1.length()) {
			if (s2.equals(res)) {
				return true;
			}
			return false;
		}
		return subRec(s1, s2, level + 1, res) || subRec(s1, s2, level + 1, res + s1.charAt(level));
	}

	// iterative solution.
	public static boolean isSubsequenceIterative(String s, String t) {
		if (s == null || s.equals("")) {
			return true;
		}
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			if (j == s.length()) {
				return true;
			}
			if (t.charAt(i) == s.charAt(j)) {
				j++;
			}
		}
		return (j == s.length()) ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCD";
		String s2 = "BD";
		System.out.println("Is s2 subsequence of s1: " + isSubsequence(s1, s2));
		System.out.println("Is s2 subsequence of s1: " + isSubsequenceIterative(s2, s1));
	}

}
