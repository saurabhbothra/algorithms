package com.algorithms.practice.trie;

class TrieNode2 {
	TrieNode2[] childs = new TrieNode2[26];
	boolean isEnd;
	int count = 1;
}

public class Trie2 {

	// A trie (pronounced as "try") or prefix tree is a tree data structure used to
	// efficiently store and retrieve keys in a dataset of strings. There are
	// various applications of this data structure, such as autocomplete and
	// spellchecker.

	// 1 <= word.length, prefix.length <= 2000

	// word and prefix consist only of lowercase English letters.

	// At most 3 * 10^4 calls in total will be made to insert, countWordsEqualTo,
	// countWordsStartingWith, and erase.

	// It is guaranteed that for any function call to erase, the string word will
	// exist in the trie.

	public TrieNode2 root;

	// initializes your data structure.
	public Trie2() {
		this.root = new TrieNode2();
	}

	// inserts the string word into the trie.
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		TrieNode2 curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				curr.childs[ch - 'a'] = new TrieNode2();
			} else {
				curr.childs[ch - 'a'].count += 1;
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.isEnd = true;
	}

	// returns the number of instances of the string word in the trie.
	public int countWordsEqualTo(String word) {
		if (word == null || word.length() == 0) {
			return 0;
		}
		TrieNode2 curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				return 0;
			}
			curr = curr.childs[ch - 'a'];
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (curr.childs[i] != null) {
				count = count + curr.childs[i].count;
			}
		}
		return curr.count - count;
	}

	// returns the number of strings in the trie that have the string prefix as a
	// prefix.
	public int countWordsStartingWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return 0;
		}
		TrieNode2 curr = this.root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				return 0;
			}
			curr = curr.childs[ch - 'a'];
		}
		return curr.count;
	}

	// erases the string word from the trie.
	public void erase(String word) {
		this.root = deleteRec(word, this.root, 0);
	}

	public TrieNode2 deleteRec(String word, TrieNode2 curr, int index) {
		if (index == word.length()) {
			if (isSafe(curr)) {
				if (curr.count == 1) {
					curr = null;
				} else {
					curr.count = curr.count - 1;
				}
				return curr;
			}
			int childCount = 0;
			for (int i = 0; i < 26; i++) {
				if (curr.childs[i] != null) {
					childCount += curr.childs[i].count;
				}
			}
			curr.count = curr.count - 1;
			if (curr.count == childCount) {
				curr.isEnd = false;
			}
			return curr;
		}
		TrieNode2 temp = deleteRec(word, curr.childs[word.charAt(index) - 'a'], index + 1);
		curr.childs[word.charAt(index) - 'a'] = temp;
		if (index == 0) {
			return curr;
		}
		if (isSafe(curr) && curr.isEnd == false && curr.count == 1) {
			return null;
		}
		curr.count = curr.count - 1;
		return curr;
	}

	public boolean isSafe(TrieNode2 node) {
		for (int i = 0; i < 26; i++) {
			if (node.childs[i] != null) {
				return false;
			}
		}
		return true;
	}

}
