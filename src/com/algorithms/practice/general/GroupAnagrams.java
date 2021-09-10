package com.algorithms.practice.general;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {

	// Given an array of strings strs, group the anagrams together. You can return
	// the answer in any order.

	// An Anagram is a word or phrase formed by rearranging the letters of a
	// different word or phrase, typically using all the original letters exactly
	// once.

	// strs[i] consists of lowercase English letters.

	// efficient solution.
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> hmap = new HashMap<>();
		for (String s : strs) {
			StringBuilder sb = new StringBuilder("");
			int[] key = new int[26];
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				key[ch - 'a'] += 1;
			}
			sb.append(key[0]);
			for (int i = 1; i < 26; i++) {
				sb.append("." + key[i]);
			}
			String k = sb.toString();
			if (!hmap.containsKey(k)) {
				hmap.put(k, new ArrayList<>());
			}
			hmap.get(k).add(s);
		}

		for (String key : hmap.keySet()) {
			result.add(hmap.get(key));
		}
		return result;
	}

}
