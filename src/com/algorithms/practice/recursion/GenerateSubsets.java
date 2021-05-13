package com.algorithms.practice.recursion;

public class GenerateSubsets {

	// Given a string of length n, generate all subsets of the string.
	// All characters in input string are distinct.
	// For a string of length n, there will be 2^n subsets.

	public static void printSubsets(String s, String prev, int level) {
		if (level == s.length()) {
			System.out.print(prev + " ");
			return;
		}
		printSubsets(s, prev, level + 1);
		printSubsets(s, prev + s.charAt(level), level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("All possible subsets are:");
		String s = "ABC";
		printSubsets(s, "", 0);
	}

}
