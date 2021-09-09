package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

	// Given an m x n board of characters and a list of strings words, return all
	// words on the board.

	// Each word must be constructed from letters of sequentially adjacent cells,
	// where adjacent cells are horizontally or vertically neighboring. The same
	// letter cell may not be used more than once in a word.

	// dfs with backtracking.
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			for (int i = 0; i < board.length; i++) {
				boolean wordFound = false;
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == word.charAt(0)) {
						if (dfs(board, i, j, word, 0)) {
							wordFound = true;
							result.add(word);
							break;
						}
					}
				}
				if (wordFound) {
					break;
				}
			}
		}
		return result;
	}

	private boolean dfs(char[][] board, int r, int c, String word, int index) {
		if (index == word.length()) {
			return true;
		}
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
			return false;
		}
		board[r][c] = '.';
		boolean flag = dfs(board, r + 1, c, word, index + 1) || dfs(board, r - 1, c, word, index + 1)
				|| dfs(board, r, c + 1, word, index + 1) || dfs(board, r, c - 1, word, index + 1);
		board[r][c] = word.charAt(index);
		return flag;
	}

	// Idea.

	// We build a Trie out of the words in the dictionary, which would be used for
	// the matching process later.

	// Starting from each cell, we start the backtracking exploration (i.e.
	// backtracking(cell)), if there exists any word in the dictionary that starts
	// with the letter in the cell.

	// During the recursive function call backtracking(cell), we explore the
	// neighbor cells (i.e. neighborCell) around the current cell for the next
	// recursive call backtracking(neighborCell). At each call, we check if the
	// sequence of letters that we traverse so far matches any word in the
	// dictionary, with the help of the Trie data structure that we built at the
	// beginning.

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

	private TrieNode search(String word) {
		TrieNode curr = this.root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				return null;
			}
			curr = curr.childs[ch - 'a'];
		}
		return curr;
	}

	public List<String> findWordsTrie(char[][] board, String[] words) {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			this.insert(word);
		}
		for (int i = 0; i < board.length; i++) {
			boolean allWordsFound = false;
			for (int j = 0; j < board[i].length; j++) {
				if (this.root.childs[board[i][j] - 'a'] != null) {
					dfs(board, i, j, result, "");
					if (result.size() == words.length) {
						allWordsFound = true;
						break;
					}
				}
			}
			if (allWordsFound) {
				break;
			}
		}
		return new ArrayList<>(result);
	}

	private void dfs(char[][] board, int r, int c, Set<String> result, String word) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '.') {
			return;
		}
		String temp = word + board[r][c];
		TrieNode curr = search(temp);
		if (curr == null) {
			return;
		}
		if (curr.isEnd) {
			result.add(temp);
		}

		board[r][c] = '.';
		dfs(board, r + 1, c, result, temp);
		dfs(board, r - 1, c, result, temp);
		dfs(board, r, c + 1, result, temp);
		dfs(board, r, c - 1, result, temp);
		board[r][c] = temp.charAt(temp.length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch2 ws = new WordSearch2();
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		System.out.println("The words that exist in board are:");
		List<String> result = ws.findWords(board, words);
		for (String word : result) {
			System.out.print(word + " ");
		}
		System.out.println();
	}

}
