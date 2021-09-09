package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class WordBreak2 {

	// Given a string s and a dictionary of strings wordDict, add spaces in s to
	// construct a sentence where each word is a valid dictionary word. Return all
	// such possible sentences in any order.

	// Note that the same word in the dictionary may be reused multiple times in the
	// segmentation.

	// 1 <= s.length <= 20
	// 1 <= wordDict.length <= 1000
	// 1 <= wordDict[i].length <= 10
	// s and wordDict[i] consist of only lowercase English letters.
	// All the strings of wordDict are unique.

	// simple recursive solution.
	public List<String> wordBreakSimple(String s, List<String> wordDict) {
		List<String> result = new ArrayList<>();
		Set<String> hset = new HashSet<>();
		for (String word : wordDict) {
			hset.add(word);
		}
		wordRec(s, 0, hset, "", result);
		return result;
	}

	private void wordRec(String s, int start, Set<String> hset, String sentence, List<String> result) {
		if (start == s.length()) {
			result.add(sentence);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			char ch = s.charAt(i);
			sb.append(ch);
			if (hset.contains(sb.toString())) {
				String temp = "";
				if (sentence.equals("")) {
					temp = sb.toString();
				} else {
					temp = sentence + " " + sb.toString();
				}
				wordRec(s, i + 1, hset, temp, result);
			}
		}
	}

	// dp memoization.
	public List<String> wordBreakMemo(String s, List<String> wordDict) {
		List<String> dummy = new ArrayList<>();
		Set<String> hset = new HashSet<>();
		for (String word : wordDict) {
			hset.add(word);
		}
		Map<Integer, List<String>> memo = new HashMap<>();
		return wordRec(s, 0, hset, memo, dummy);
	}

	private List<String> wordRec(String s, int start, Set<String> hset, Map<Integer, List<String>> memo,
			List<String> dummy) {
		if (start == s.length()) {
			memo.put(start, new ArrayList<>());
		}
		if (memo.get(start) == null) {
			List<String> sentences = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = start; i < s.length(); i++) {
				char ch = s.charAt(i);
				sb.append(ch);
				if (hset.contains(sb.toString())) {
					List<String> futureSentences = wordRec(s, i + 1, hset, memo, dummy);
					if (futureSentences == dummy) {
						continue;
					} else if (futureSentences.size() == 0) {
						sentences.add(sb.toString());
					} else {
						String currWord = sb.toString();
						for (String sen : futureSentences) {
							sentences.add(currWord + " " + sen);
						}
					}
				}
			}
			if (sentences.size() == 0) {
				sentences = dummy;
			}
			memo.put(start, sentences);
		}
		return memo.get(start);
	}

	// dp tabulation.
	public List<String> wordBreakTabulation(String s, List<String> wordDict) {
		List<String> dummy = new ArrayList<>();
		Set<String> hset = new HashSet<>();
		for (String word : wordDict) {
			hset.add(word);
		}
		Map<Integer, List<String>> dp = new HashMap<>();
		dp.put(s.length(), new ArrayList<>());
		for (int start = s.length() - 1; start >= 0; start--) {
			List<String> sentences = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = start; i < s.length(); i++) {
				char ch = s.charAt(i);
				sb.append(ch);
				if (hset.contains(sb.toString())) {
					List<String> futureSentences = dp.get(i + 1);
					if (futureSentences == dummy) {
						continue;
					} else if (futureSentences.size() == 0) {
						sentences.add(sb.toString());
					} else {
						String currWord = sb.toString();
						for (String sen : futureSentences) {
							sentences.add(currWord + " " + sen);
						}
					}
				}
			}
			if (sentences.size() == 0) {
				sentences = dummy;
			}
			dp.put(start, sentences);
		}
		return dp.get(0);
	}

	// dp tabulation with trie.
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

	public List<String> wordBreakDpTrie(String s, List<String> wordDict) {
		List<String> dummy = new ArrayList<>();
		for (String word : wordDict) {
			this.insert(word);
		}
		Map<Integer, List<String>> dp = new HashMap<>();
		dp.put(s.length(), new ArrayList<>());
		for (int start = s.length() - 1; start >= 0; start--) {
			List<String> sentences = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = start; i < s.length(); i++) {
				char ch = s.charAt(i);
				sb.append(ch);
				if (this.search(sb.toString())) {
					List<String> futureSentences = dp.get(i + 1);
					if (futureSentences == dummy) {
						continue;
					} else if (futureSentences.size() == 0) {
						sentences.add(sb.toString());
					} else {
						String currWord = sb.toString();
						for (String sen : futureSentences) {
							sentences.add(currWord + " " + sen);
						}
					}
				}
			}
			if (sentences.size() == 0) {
				sentences = dummy;
			}
			dp.put(start, sentences);
		}
		return dp.get(0);
	}

}
