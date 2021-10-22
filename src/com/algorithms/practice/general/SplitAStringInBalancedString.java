package com.algorithms.practice.general;

public class SplitAStringInBalancedString {

	// Balanced strings are those that have an equal quantity of 'L' and 'R'
	// characters.

	// Given a balanced string s, split it in the maximum amount of balanced
	// strings.

	// Return the maximum amount of split balanced strings.

	// 1 <= s.length <= 1000
	// s[i] is either 'L' or 'R'.
	// s is a balanced string.

	// efficient solution.
	public static int balancedStringSplit(String s) {
		int count = 0;
		int balance = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'L') {
				balance++;
			} else {
				balance--;
			}
			if (balance == 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The maximum number of balanced strings are: " + balancedStringSplit("RLRRLLRLRL"));
	}

}
