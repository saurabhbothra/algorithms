package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
	TrieNode[] childs = new TrieNode[26];
	boolean isEnd;
}

public class WordBreakTrie {

	// Given a string s and a dictionary of strings wordDict, return true if s can
	// be segmented into a space-separated sequence of one or more dictionary words.

	// Note that the same word in the dictionary may be reused multiple times in the
	// segmentation.

	// 1 <= s.length <= 300
	// 1 <= wordDict.length <= 1000
	// 1 <= wordDict[i].length <= 20
	// s and wordDict[i] consist of only lowercase English letters.
	// All the strings of wordDict are unique.

	private TrieNode root = new TrieNode();

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

	private boolean search(String word) {
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

	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		for (String word : wordDict) {
			this.insert(word);
		}
		dp[s.length()] = true;
		for (int i = s.length() - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			boolean flag = false;
			for (int j = i; j < s.length(); j++) {
				sb.append(s.charAt(j));
				if (this.search(sb.toString())) {
					if (dp[j + 1]) {
						flag = true;
						break;
					}
				}
			}
			dp[i] = flag;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakTrie wb = new WordBreakTrie();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println("Can s be segmented: " + wb.wordBreak("leetcode", wordDict));
	}

}
