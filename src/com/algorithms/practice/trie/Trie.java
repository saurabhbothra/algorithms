package com.algorithms.practice.trie;

import java.util.Set;
import java.util.HashSet;

public class Trie {

	// A trie (pronounced as "try") or prefix tree is a tree data structure used to
	// efficiently store and retrieve keys in a dataset of strings. There are
	// various applications of this data structure, such as autocomplete and
	// spellchecker.

	// 1 <= word.length, prefix.length <= 2000.
	// word and prefix consist only of lowercase English letters.

	// At most 3 * 10^4 calls in total will be made to insert, search, and
	// startsWith.

	public TrieNode root;

	// initialize your data structure here.
	public Trie() {
		this.root = new TrieNode();
	}

	// inserts a word into the trie.
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
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

	// returns if the word is in the trie.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		TrieNode curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				return false;
			}
			curr = curr.childs[ch - 'a'];
		}
		return curr.isEnd;
	}

	// returns if there is any word in the trie that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return true;
		}
		TrieNode curr = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				return false;
			}
			curr = curr.childs[ch - 'a'];
		}
		return true;
	}

	// deletes a word from trie.
	public void delete(String word) {
		this.root = deleteRec(word, this.root, 0);
	}

	private TrieNode deleteRec(String word, TrieNode curr, int index) {
		if (index == word.length()) {
			curr.isEnd = false;
			return isSafe(curr) ? null : curr;
		}
		TrieNode temp = deleteRec(word, curr.childs[word.charAt(index) - 'a'], index + 1);
		curr.childs[word.charAt(index) - 'a'] = temp;
		if (index == 0) {
			return curr;
		}
		if (isSafe(curr) && curr.isEnd == false) {
			return null;
		}
		return curr;
	}

	private boolean isSafe(TrieNode node) {
		for (int i = 0; i < 26; i++) {
			if (node.childs[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		Set<String> hset = new HashSet<>();
		hset.add("geek");
		hset.add("geeks");
		hset.add("bad");
		hset.add("bat");
		hset.add("app");
		hset.add("apple");
		hset.add("zoo");
		for (String word : hset) {
			t.insert(word);
		}
		for (String word : hset) {
			t.delete(word);
			System.out.println(t.search(word));
		}

	}

}
