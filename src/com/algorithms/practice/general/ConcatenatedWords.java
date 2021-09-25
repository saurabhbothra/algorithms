package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.algorithms.practice.trie.TrieNode;

public class ConcatenatedWords {

	// Given an array of strings words (without duplicates), return all the
	// concatenated words in the given list of words.

	// A concatenated word is defined as a string that is comprised entirely of at
	// least two shorter words in the given array.

	// words[i] consists of only lowercase English letters.

	public TrieNode root = new TrieNode();

	private void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				curr.childs[ch - 'a'] = new TrieNode();
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.isEnd = true;
	}

	// recursive naive solution.
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		for (String word : words) {
			this.insert(word);
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (isConcatenated(words, words[i], 0)) {
				result.add(words[i]);
			}
		}
		return result;
	}

	private boolean isConcatenated(String[] words, String word, int count) {
		if (word.equals("")) {
			return false;
		}
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				return false;
			} else if (curr.childs[ch - 'a'].isEnd) {
				if (isConcatenated(words, word.substring(i + 1, word.length()), count + 1)) {
					return true;
				}
			}
			curr = curr.childs[ch - 'a'];
		}

		if (curr.isEnd && count >= 1) {
			return true;
		}
		return false;
	}

	// memoization.
	public List<String> findAllConcatenatedWordsInADictMemo(String[] words) {
		for (String word : words) {
			this.insert(word);
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (isConcatenated(words[i], 0, 0, new HashMap<>())) {
				result.add(words[i]);
			}
		}
		return result;
	}

	private boolean isConcatenated(String word, int index, int count, Map<Integer, Boolean> hmap) {
		if (hmap.containsKey(index)) {
			return hmap.get(index);
		}

		if (index == word.length()) {
			hmap.put(index, count > 1);
			return hmap.get(index);
		}

		TrieNode curr = root;
		for (int i = index; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				hmap.put(index, false);
				return false;
			} else if (curr.childs[ch - 'a'].isEnd) {
				if (isConcatenated(word, i + 1, count + 1, hmap)) {
					hmap.put(index, true);
					return true;
				}
			}
			curr = curr.childs[ch - 'a'];
		}

		hmap.put(index, false);
		return false;
	}

}
