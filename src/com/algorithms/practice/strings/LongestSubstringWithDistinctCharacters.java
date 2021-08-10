package com.algorithms.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {

	// Given a string, we need to find out length of longest substring of the string
	// with distinct characters.

	// s consists of English letters, digits, symbols and spaces.

	// naive solution
	public static int findLongestSubstring(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isDistinct(s, i, j)) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		return res;
	}

	// helper method to check if characters are distinct from i to j.
	public static boolean isDistinct(String s, int i, int j) {
		boolean[] visited = new boolean[256];
		for (int k = i; k <= j; k++) {
			if (visited[s.charAt(k)]) {
				return false;
			}
			visited[s.charAt(k)] = true;
		}
		return true;
	}

	// naive solution 1.
	public static int findLongestSubstringNaive(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		int maxLength = 1;
		Set<Character> hset = null;
		for (int i = 2; i <= s.length(); i++) {
			int numberOfWindows = s.length() - i + 1;
			for (int j = 0; j < numberOfWindows; j++) {
				boolean isDistinct = true;
				hset = new HashSet<>();
				for (int k = 0; k < i; k++) {
					if (hset.contains(s.charAt(j + k))) {
						isDistinct = false;
						break;
					}
					hset.add(s.charAt(j + k));
				}
				if (isDistinct) {
					maxLength += 1;
					break;
				}
			}
		}
		return maxLength;
	}

	// naive solution 2.
	public static int findLongestSubstringNaiveOne(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			boolean[] visited = new boolean[128];
			for (int j = i; j < s.length(); j++) {
				if (visited[s.charAt(j)]) {
					break;
				} else {
					visited[s.charAt(j)] = true;
					res = Math.max(res, j - i + 1);
				}
			}
		}
		return res;
	}

	// efficient solution.
	public static int findLongestSubstringEfficient(String s) {
		int res = 0;
		int i = 0;
		int[] arr = new int[128];
		for (int j = 0; j < 128; j++) {
			arr[j] = -1;
		}
		int startIndex = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (arr[ch] == -1 || arr[ch] < startIndex) {
				arr[ch] = i;
			} else {
				res = Math.max(res, i - startIndex);
				startIndex = arr[ch] + 1;
				arr[ch] = i;
			}
			i++;
		}
		return Math.max(res, i - startIndex);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaacdbab";
		System.out.println(
				"The length of longest substring with distinct characters is: " + findLongestSubstringNaive(s));
	}

}
