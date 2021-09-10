package com.algorithms.practice.general;

public class LongestCommonPrefix {

	// Write a function to find the longest common prefix string amongst an array of
	// strings.

	// If there is no common prefix, return an empty string "".

	// strs[i] consists of only lower-case English letters.

	// 1 <= strs.length <= 200
	// 0 <= strs[i].length <= 200

	// Ideas:
	// 1) You can do a horizontal scan.
	// 2) You can do divide and conquer.
	// 3) You can implement a trie.

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

	// solution using trie.
	public String longestCommonPrefix(String[] strs) {
		for (String s : strs) {
			if (s.equals("")) {
				return "";
			}
			this.insert(s);
		}
		StringBuilder sb = new StringBuilder("");
		TrieNode curr = this.root;
		while (true) {
			int count = 0;
			char key = '\u0000';
			for (char c = 'a'; c <= 'z'; c++) {
				if (curr.childs[c - 'a'] != null) {
					count++;
					key = c;
				}
			}
			if (count != 1) {
				break;
			} else {
				sb.append(key);
				curr = curr.childs[key - 'a'];
				if (curr.isEnd) {
					break;
				}
			}
		}
		return sb.toString();
	}

	// solution using horizontal scanning.
	public String longestCommonPrefixScanning(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String s = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int minLen = Math.min(s.length(), strs[i].length());
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < minLen; j++) {
				if (s.charAt(j) == strs[i].charAt(j)) {
					sb.append(s.charAt(j));
				} else {
					break;
				}
			}
			s = sb.toString();
		}
		return s;
	}

	// solution using divide and conquer.
	public String longestCommonPrefixDivide(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		return lcpRec(strs, 0, strs.length - 1);
	}

	private String lcpRec(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		}
		int mid = start + (end - start) / 2;
		String leftPrefix = lcpRec(strs, start, mid);
		String rightPrefix = lcpRec(strs, mid + 1, end);
		int minLen = Math.min(leftPrefix.length(), rightPrefix.length());
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < minLen; i++) {
			if (leftPrefix.charAt(i) == rightPrefix.charAt(i)) {
				sb.append(leftPrefix.charAt(i));
			} else {
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = { "flower", "flow", "flight" };
		System.out.println("The longest common prefix is: " + lcp.longestCommonPrefix(strs));
		System.out.println("The longest common prefix is: " + lcp.longestCommonPrefixScanning(strs));
		System.out.println("The longest common prefix is: " + lcp.longestCommonPrefixDivide(strs));
	}

}
