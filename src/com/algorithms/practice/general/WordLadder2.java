package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class WordLadder2 {

	// A transformation sequence from word beginWord to word endWord using a
	// dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
	// such that:

	// Every adjacent pair of words differs by a single letter.

	// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
	// be in wordList.

	// sk == endWord

	// Given two words, beginWord and endWord, and a dictionary wordList, return all
	// the shortest transformation sequences from beginWord to endWord, or an empty
	// list if no such sequence exists. Each sequence should be returned as a list
	// of the words [beginWord, s1, s2, ..., sk].

	// 1 <= beginWord.length <= 5
	// endWord.length == beginWord.length
	// 1 <= wordList.length <= 1000
	// wordList[i].length == beginWord.length
	// beginWord, endWord, and wordList[i] consist of lowercase English letters.
	// beginWord != endWord
	// All the words in wordList are unique.

	List<List<String>> result = new ArrayList<>();

	private List<String> findChilds(String word, Set<String> dictionary) {
		int l = word.length();
		char[] chr = word.toCharArray();
		List<String> childs = new ArrayList<>();
		for (char j = 'a'; j <= 'z'; j++) {
			for (char i = 0; i < l; i++) {
				char ch = chr[i];
				chr[i] = j;
				String temp = String.valueOf(chr);
				if (dictionary.contains(temp) && !word.equals(temp)) {
					childs.add(temp);
				}
				chr[i] = ch;
			}
		}
		return childs;
	}

	// single bfs.
	public List<List<String>> findLaddersBfs(String beginWord, String endWord, List<String> wordList) {
		Set<String> dictionary = new HashSet<>(wordList);
		Map<String, List<String>> adj = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();
		Set<String> visited = new HashSet<>();
		dictionary.add(beginWord);
		if (!dictionary.contains(endWord)) {
			return result;
		}
		int count = bfs(beginWord, endWord, adj, visited, dictionary, distance);
		backtrack(count, beginWord, endWord, adj, new ArrayList<>(), distance);
		return result;
	}

	private void backtrack(int count, String source, String endWord, Map<String, List<String>> adj,
			List<String> transformedWords, Map<String, Integer> distance) {
		if (source.equals(endWord)) {
			List<String> newList = new ArrayList<>(transformedWords);
			newList.add(endWord);
			result.add(newList);
			return;
		}
		if (!adj.containsKey(source)) {
			return;
		}
		transformedWords.add(source);
		List<String> childs = adj.get(source);
		for (int j = 0; j < childs.size(); j++) {
			String child = childs.get(j);
			if (distance.get(child) == 1 + distance.get(source)) {
				backtrack(count, child, endWord, adj, transformedWords, distance);
			}
		}
		transformedWords.remove(transformedWords.size() - 1);
	}

	private int bfs(String beginWord, String endWord, Map<String, List<String>> adj, Set<String> visited,
			Set<String> dictionary, Map<String, Integer> distance) {
		ArrayDeque<String> q = new ArrayDeque<>();
		visited.add(beginWord);
		q.offer(beginWord);
		distance.put(beginWord, 0);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String poppedWord = q.poll();
				if (poppedWord.equals(endWord)) {
					return count + 1;
				}
				List<String> childs = this.findChilds(poppedWord, dictionary);
				for (int k = 0; k < childs.size(); k++) {
					String child = childs.get(k);
					if (!adj.containsKey(poppedWord)) {
						adj.put(poppedWord, new ArrayList<>());
					}
					adj.get(poppedWord).add(child);
					if (!visited.contains(child)) {
						distance.put(child, distance.get(poppedWord) + 1);
						visited.add(child);
						q.offer(child);
					}
				}
			}
			count++;
		}
		return 0;
	}

}
