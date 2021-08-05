package com.algorithms.practice.strings;

public class PalindromeCheck {

	// Given a string, check whether given string is palindrome or not.

	// naive implementation.
	public static boolean isPalindromeNaive(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		String rev = sb.toString();
		return s.equals(rev);
	}

	// efficient implementation.
	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			char l = s.charAt(start);
			char r = s.charAt(end);
			if (l != r) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABCDCBA";
		String s1 = "ABBA";
		String s2 = "geeks";
		System.out.println("Is given string palindrome: " + isPalindrome(s));
		System.out.println("Is given string palindrome: " + isPalindrome(s1));
		System.out.println("Is given string palindrome: " + isPalindrome(s2));
	}

}
