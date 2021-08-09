package com.algorithms.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsSearch {

	// Given two strings s and p, return an array of all the start indices of p's
	// anagrams in s. You may return the answer in any order.
	// s and p consist of lowercase English letters.

	// naive solution.
	public static List<Integer> findAnagramsNaive(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] arr = new int[26];
		for (int i = 0; i < p.length(); i++) {
			arr[p.charAt(i) - 'a'] += 1;
		}
		int numOfWindows = s.length() - p.length() + 1;
		for (int i = 0; i < numOfWindows; i++) {
			for (int j = 0; j < p.length(); j++) {
				arr[s.charAt(i + j) - 'a'] -= 1;
			}
			boolean isAnagram = true;
			for (int k = 0; k < arr.length; k++) {
				if (arr[k] != 0) {
					isAnagram = false;
					arr[k] = 0;
				}
			}
			if (isAnagram) {
				result.add(i);
			}
			for (int k = 0; k < p.length(); k++) {
				arr[p.charAt(k) - 'a'] += 1;
			}
		}
		return result;
	}

	// efficient solution.
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length()) {
			return result;
		}
		int[] patternArr = new int[26];
		int[] textArr = new int[26];
		for (int i = 0; i < p.length(); i++) {
			patternArr[p.charAt(i) - 'a'] += 1;
			textArr[s.charAt(i) - 'a'] += 1;
		}
		int numberOfWindows = s.length() - p.length() + 1;
		for (int i = 0; i < numberOfWindows; i++) {
			if (Arrays.equals(textArr, patternArr)) {
				result.add(i);
			}
			if (i < numberOfWindows - 1) {
				textArr[s.charAt(i + p.length()) - 'a'] += 1;
				textArr[s.charAt(i) - 'a'] -= 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println("The indexes are:");
		List<Integer> indexes = findAnagrams(s, p);
		for (Integer i : indexes) {
			System.out.print(i + " ");
		}
	}

}
