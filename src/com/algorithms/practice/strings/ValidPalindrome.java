package com.algorithms.practice.strings;

public class ValidPalindrome {

	// Given a string s, determine if it is a palindrome, considering only
	// alphanumeric characters and ignoring cases.

	// efficient implementation.
	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			}
			while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			}
			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		String s1 = "race a car";
		System.out.println("Is given string palindrome: " + isPalindrome(s));
		System.out.println("Is given string palindrome: " + isPalindrome(s1));
	}

}
