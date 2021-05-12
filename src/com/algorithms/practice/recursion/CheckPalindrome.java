package com.algorithms.practice.recursion;

public class CheckPalindrome {

	// Given a string, check if it's a palindrome or not.

	// recursive solution.
	public static boolean checkPalindrome(String s) {
		if (s.length() == 1 || s.equals("")) {
			return true;
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return checkPalindrome(s.substring(1, s.length() - 1));
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Is given string palindrome: " + checkPalindrome("abbcbba"));

	}

}
