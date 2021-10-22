package com.algorithms.practice.general;

public class ShuffleString {

	// Given a string s and an integer array indices of the same length.

	// The string s will be shuffled such that the character at the ith position
	// moves to indices[i] in the shuffled string.

	// Return the shuffled string.

	// s.length == indices.length == n.
	// s contains only lower-case English letters.
	// All values of indices are unique (i.e. indices is a permutation of the
	// integers from 0 to n - 1).

	// efficient solution.
	public static String restoreString(String s, int[] indices) {
		char[] result = new char[indices.length];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			result[indices[i]] = ch;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : result) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] indices = { 4, 0, 2, 6, 7, 3, 1, 5 };
		System.out.println("The restored string is: " + restoreString("aaiougrt", indices));
	}

}
