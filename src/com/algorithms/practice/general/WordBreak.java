package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	// Given a string s and a dictionary of strings wordDict, return true if s can
	// be segmented into a space-separated sequence of one or more dictionary words.

	// Note that the same word in the dictionary may be reused multiple times in the
	// segmentation.

	// 1 <= s.length <= 300
	// 1 <= wordDict.length <= 1000
	// 1 <= wordDict[i].length <= 20
	// s and wordDict[i] consist of only lowercase English letters.
	// All the strings of wordDict are unique.

	// simple recursive solution.
	public boolean wordBreakSimple(String s, List<String> wordDict) {
		Set<String> hset = new HashSet<>();
		for (String word : wordDict) {
			hset.add(word);
		}
		return wordRec(s, 0, hset);
	}

	private boolean wordRec(String s, int start, Set<String> hset) {
		if (start == s.length()) {
			return true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (hset.contains(sb.toString())) {
				if (wordRec(s, i + 1, hset)) {
					return true;
				}
			}
		}
		return false;
	}

	// dp memoization.
	public boolean wordBreakMemo(String s, List<String> wordDict) {
		Set<String> hset = new HashSet<>();
		Boolean[] memo = new Boolean[s.length() + 1];
		for (String word : wordDict) {
			hset.add(word);
		}
		return wordRec(s, 0, hset, memo);
	}

	private boolean wordRec(String s, int start, Set<String> hset, Boolean[] memo) {
		if (start == s.length()) {
			memo[start] = true;
		}
		if (memo[start] == null) {
			StringBuilder sb = new StringBuilder();
			boolean flag = false;
			for (int i = start; i < s.length(); i++) {
				sb.append(s.charAt(i));
				if (hset.contains(sb.toString())) {
					if (wordRec(s, i + 1, hset, memo)) {
						flag = true;
						break;
					}
				}
			}
			memo[start] = flag;
		}
		return memo[start];
	}

	// dp tabulation.
	public boolean wordBreakTabulation(String s, List<String> wordDict) {
		Set<String> hset = new HashSet<>();
		boolean[] dp = new boolean[s.length() + 1];
		for (String word : wordDict) {
			hset.add(word);
		}
		dp[s.length()] = true;
		for (int i = s.length() - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			boolean flag = false;
			for (int j = i; j < s.length(); j++) {
				sb.append(s.charAt(j));
				if (hset.contains(sb.toString())) {
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
		WordBreak wb = new WordBreak();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println("Can s be segmented: " + wb.wordBreakSimple("leetcode", wordDict));
		System.out.println("Can s be segmented: " + wb.wordBreakMemo("leetcode", wordDict));
		System.out.println("Can s be segmented: " + wb.wordBreakTabulation("leetcode", wordDict));
	}

}
