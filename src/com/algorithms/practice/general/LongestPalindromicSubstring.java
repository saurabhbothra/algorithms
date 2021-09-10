package com.algorithms.practice.general;

public class LongestPalindromicSubstring {

	// Given a string s, return the longest palindromic substring in s.

	// 1 <= s.length <= 1000
	// s consist of only digits and English letters.
	// s consist of only digits and English letters.

	// efficient solution, expanding outwards by treating each element as middle.
	public static String longestPalindromeEfficient(String s) {
		int left = -1;
		int right = -1;
		for (int i = 0; i < s.length(); i++) {
			int[] even = null;
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				even = checkPalindrome(s, i, i + 1);
			}
			int[] odd = checkPalindrome(s, i, i);
			if (even != null) {
				if (left == -1 || (even[1] - even[0] + 1) > (right - left + 1)) {
					left = even[0];
					right = even[1];
				}
			}
			if (left == -1 || (odd[1] - odd[0] + 1) > (right - left + 1)) {
				left = odd[0];
				right = odd[1];
			}
		}
		return s.substring(left, right + 1);
	}

	private static int[] checkPalindrome(String s, int i, int j) {
		int[] result = new int[2];
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				result[0] = i;
				result[1] = j;
				i--;
				j++;
			} else {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The longest palindromic substring is: " + longestPalindromeEfficient("babad"));
	}

}
