package com.algorithms.practice.strings;

import java.util.Arrays;

public class CheckForAnagram {

	// Given two strings s and t, return true if t is an anagram of s, and false
	// otherwise.

	// Follow up: What if the inputs contain Unicode characters? How would you adapt
	// your solution to such a case?

	// 1 <= s.length, t.length <= 5 * 10^4
	// s and t consist of lowercase English letters.

	// naive solution.
	public static boolean isAnagramNaive(String s, String t) {
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		Arrays.sort(sarr);
		Arrays.sort(tarr);
		return String.valueOf(sarr).equals(String.valueOf(tarr));
	}

	// efficient solution.
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println("Are s and t anagrams: " + isAnagram(s, t));
	}

}
