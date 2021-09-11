package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {

	// Given an array of strings products and a string searchWord. We want to design
	// a system that suggests at most three product names from products after each
	// character of searchWord is typed. Suggested products should have common
	// prefix with the searchWord. If there are more than three products with a
	// common prefix return the three lexicographically minimums products.

	// Return list of lists of the suggested products after each character of
	// searchWord is typed.

	// All characters of products[i] are lower-case English letters.

	// All characters of searchWord are lower-case English letters.
	
	// trie solution.

	public TrieNode root = new TrieNode();

	private void insert(String word) {
		TrieNode curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				curr.childs[ch - 'a'] = new TrieNode();
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.isEnd = true;
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		for (String word : products) {
			this.insert(word);
		}
		TrieNode prefixPointer = this.root;
		List<List<String>> result = new ArrayList<>();
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < searchWord.length(); i++) {
			char ch = searchWord.charAt(i);
			List<String> suggestions = new ArrayList<>();
			if (prefixPointer != null && prefixPointer.childs[ch - 'a'] != null) {
				prefix.append(ch);
				prefixPointer = prefixPointer.childs[ch - 'a'];
				findBestMatches(prefixPointer, prefix.toString(), suggestions);
			} else {
				prefixPointer = null;
			}
			result.add(suggestions);
		}
		return result;
	}

	private void findBestMatches(TrieNode curr, String suggestion, List<String> matches) {
		if (curr.isEnd) {
			if (matches.size() < 3) {
				matches.add(suggestion);
			}
		}
		for (char c = 'a'; c <= 'z'; c++) {
			if (curr.childs[c - 'a'] != null) {
				findBestMatches(curr.childs[c - 'a'], suggestion + c, matches);
			}
			if (matches.size() == 3) {
				return;
			}
		}
	}

}
