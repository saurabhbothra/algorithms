package com.algorithms.practice.recursion;

public class AllPermutationsString {

	// Given a string s, print all permutations of the given string.
	// For a string of length n, there are n! permutations.

	// recursive solution.
	public static void printPerm(String s, int level) {
		if(level == s.length()) {
			System.out.print(s + " ");
			return;
		}
		for(int j = level; j < s.length(); j++) {
			char[] charArr = s.toCharArray();
			char temp = charArr[j];
			charArr[j] = charArr[level];
			charArr[level] = temp;
			s = String.valueOf(charArr);
			printPerm(s, level + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("All possible permutations of the given string are:");
		printPerm("ABCD", 0);
	}

}
