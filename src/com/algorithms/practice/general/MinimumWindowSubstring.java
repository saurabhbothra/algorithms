package com.algorithms.practice.general;

public class MinimumWindowSubstring {

	// Given two strings s and t of lengths m and n respectively, return the minimum
	// window substring of s such that every character in t (including duplicates)
	// is included in the window. If there is no such substring, return the empty
	// string "".

	// The testcases will be generated such that the answer is unique.

	// A substring is a contiguous sequence of characters within the string.

	// m == s.length
	// n == t.length
	// 1 <= m, n <= 10^5
	// s and t consist of uppercase and lowercase English letters.

	// Follow up: Could you find an algorithm that runs in O(m + n) time?

	// naive solution.
	public static String minWindowSimple(String s, String t) {
		int[] text = new int[256];
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			text[ch] += 1;
		}
		String minWindowText = "";
		for (int i = t.length(); i <= s.length(); i++) {
			int numOfWindows = s.length() - i + 1;
			for (int j = 0; j < numOfWindows; j++) {
				int[] letters = new int[256];
				for (int k = 0; k < i; k++) {
					char ch = s.charAt(j + k);
					letters[ch] += 1;
				}
				boolean isFound = true;
				for (int x = 0; x < t.length(); x++) {
					char ch = t.charAt(x);
					if (letters[ch] < text[ch]) {
						isFound = false;
						break;
					}
				}
				if (isFound) {
					return s.substring(j, j + i);
				}
			}
		}
		return minWindowText;
	}

	// efficient solution.
	public static String minWindowEfficient(String s, String t) {
		int[] text = new int[256];
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			text[ch] += 1;
		}
		int start = 0;
		int[] letters = new int[256];
		int minStart = -1;
		int minEnd = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			letters[ch] += 1;
			if (comparePatterns(letters, text)) {
				int k = start;
				while (k < i) {
					letters[s.charAt(k)] = letters[s.charAt(k)] - 1;
					if (comparePatterns(letters, text)) {
						k++;
						start = k;
					} else {
						break;
					}
				}
				if (minStart == -1 || (i - start + 1) < (minEnd - minStart + 1)) {
					minStart = start;
					minEnd = i;
				}
				start = k + 1;
			}
		}
		return (minStart == -1) ? "" : s.substring(minStart, minEnd + 1);
	}

	private static boolean comparePatterns(int[] letters, int[] text) {
		for (int i = 0; i < 256; i++) {
			if (text[i] != 0 && letters[i] < text[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Minimum window substring is: " + minWindowSimple("adobecodebanc", "abc"));
		System.out.println("Minimum window substring is: " + minWindowEfficient("adobecodebanc", "abc"));
	}

}
