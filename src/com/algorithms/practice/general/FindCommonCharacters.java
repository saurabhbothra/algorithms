package com.algorithms.practice.general;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FindCommonCharacters {

	// Given a string array words, return an array of all characters that show up in
	// all strings within the words (including duplicates). You may return the
	// answer in any order.

	// words[i] consists of lowercase English letters.

	// solution 1.
	public static List<String> commonCharsFirst(String[] words) {
		Map<Integer, int[]> hmap = new HashMap<>();
		List<String> result = new ArrayList<>();
		int index = 0;
		for (String word : words) {
			int[] arr = new int[26];
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				arr[ch - 'a'] += 1;
			}
			hmap.put(index, arr);
			index++;
		}
		for (int j = 0; j < 26; j++) {
			char ch = (char) (j + (int) 'a');
			int count = hmap.get(0)[ch - 'a'];
			for (int i = 1; i < words.length; i++) {
				count = Math.min(count, hmap.get(i)[ch - 'a']);
			}
			while (count != 0) {
				result.add("" + ch);
				count--;
			}
		}
		return result;
	}

	// solution 2.
	public static List<String> commonChars(String[] words) {
		int[] freq = new int[26];
		List<String> result = new ArrayList<>();

		String firstWord = words[0];
		for (int i = 0; i < firstWord.length(); i++) {
			char ch = firstWord.charAt(i);
			freq[ch - 'a'] += 1;
		}

		for (int j = 1; j < words.length; j++) {
			String word = words[j];
			int[] arr = new int[26];
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				arr[ch - 'a'] += 1;
			}
			for (int i = 0; i < 26; i++) {
				freq[i] = Math.min(freq[i], arr[i]);
			}
		}

		for (char c = 'a'; c <= 'z'; c++) {
			if (freq[c - 'a'] != 0) {
				int count = freq[c - 'a'];
				while (count != 0) {
					result.add("" + c);
					count--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "bella", "label", "roller" };
		List<String> result = commonChars(words);
		for (String c : result) {
			System.out.print(c + " ");
		}
	}

}
