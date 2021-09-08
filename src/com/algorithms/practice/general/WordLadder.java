package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WordLadder {

	// A transformation sequence from word beginWord to word endWord using a
	// dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
	// such that:

	// Every adjacent pair of words differs by a single letter.

	// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
	// be in wordList.

	// sk == endWord

	// Given two words, beginWord and endWord, and a dictionary wordList, return the
	// number of words in the shortest transformation sequence from beginWord to
	// endWord, or 0 if no such sequence exists.

	// 1 <= beginWord.length <= 10
	// endWord.length == beginWord.length
	// 1 <= wordList.length <= 5000
	// wordList[i].length == beginWord.length
	// beginWord, endWord, and wordList[i] consist of lowercase English letters.
	// beginWord != endWord
	// All the words in wordList are unique.

	// solution using bfs.
	// time complexity : O(M^2 * N) -> M: length of each word, N: number of words in
	// dictionary.
	// space complexity: O(M^2 * N)
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int count = 0;
		int l = beginWord.length();
		ArrayDeque<String> q = new ArrayDeque<>();
		Map<String, Boolean> visited = new HashMap<>();
		visited.put(beginWord, false);

		// preprocessing step for creating adjacency list for graph.
		Map<String, List<String>> adj = new HashMap<>();
		for (String word : wordList) {
			visited.put(word, false);
			for (int i = 0; i < l; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i + 1, l);
				List<String> childs = adj.getOrDefault(newWord, new ArrayList<>());
				childs.add(word);
				adj.put(newWord, childs);
			}
		}

		if (!visited.containsKey(endWord)) {
			return count;
		}

		q.offer(beginWord);
		visited.put(beginWord, true);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				String poppedWord = q.poll();
				if (poppedWord.equals(endWord)) {
					return count + 1;
				}
				for (int i = 0; i < l; i++) {
					String newWord = poppedWord.substring(0, i) + "*" + poppedWord.substring(i + 1, l);
					List<String> childs = adj.getOrDefault(newWord, new ArrayList<>());
					for (int k = 0; k < childs.size(); k++) {
						String child = childs.get(k);
						if (!visited.get(child)) {
							q.offer(child);
							visited.put(child, true);
						}
					}
				}
			}
			count++;
		}
		return 0;
	}

	// The graph formed from the nodes in the dictionary might be too big. The
	// search space considered by the breadth first search algorithm depends upon
	// the branching factor of the nodes at each level. If the branching factor
	// remains the same for all the nodes, the search space increases exponentially
	// along with the number of levels. Consider a simple example of a binary tree.
	// With each passing level in a complete binary tree, the number of nodes
	// increase in powers of 2.

	// We can considerably cut down the search space of the standard breadth first
	// search algorithm if we launch two simultaneous BFS. One from the beginWord
	// and one from the endWord. We progress one node at a time from both sides and
	// at any point in time if we find a common node in both the searches, we stop
	// the search. This is known as bidirectional BFS and it considerably cuts down
	// on the search space and hence reduces the time and space complexity.

	// Algorithm.
	// The algorithm is very similar to the standard BFS based approach we saw
	// earlier.

	// The only difference is we now do BFS starting two nodes instead of one. This
	// also changes the termination condition of our search.

	// We now have two visited dictionaries to keep track of nodes visited from the
	// search starting at the respective ends.

	// If we ever find a node/word which is in the visited dictionary of the
	// parallel search we terminate our search, since we have found the meet point
	// of this bidirectional search. It's more like meeting in the middle instead of
	// going all the way through.

	// Termination condition for bidirectional search is finding a word which is
	// already been seen by the parallel search.

	// The shortest transformation sequence is the sum of levels of the meet point
	// node from both the ends. Thus, for every visited node we save its level as
	// value in the visited dictionary.

	// solution using bidirectional bfs.
	public int ladderLengthBi(String beginWord, String endWord, List<String> wordList) {
		int leftCount = 0;
		int rightCount = 0;
		int l = beginWord.length();
		ArrayDeque<String> qLeft = new ArrayDeque<>();
		ArrayDeque<String> qRight = new ArrayDeque<>();
		Map<String, Boolean> visitedLeft = new HashMap<>();
		Map<String, Boolean> visitedRight = new HashMap<>();
		visitedLeft.put(beginWord, false);
		visitedRight.put(beginWord, false);

		// preprocessing step for creating adjacency list for graph.
		Map<String, List<String>> adj = new HashMap<>();
		for (String word : wordList) {
			visitedLeft.put(word, false);
			visitedRight.put(word, false);
			for (int i = 0; i < l; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i + 1, l);
				List<String> childs = adj.getOrDefault(newWord, new ArrayList<>());
				childs.add(word);
				adj.put(newWord, childs);
			}
		}

		if (!visitedLeft.containsKey(endWord)) {
			return 0;
		}

		qLeft.offer(beginWord);
		qRight.offer(endWord);
		visitedLeft.put(beginWord, true);
		visitedRight.put(endWord, true);
		while (!qLeft.isEmpty() && !qRight.isEmpty()) {
			// processing left queue.
			if (processNode(qLeft, visitedLeft, adj, visitedRight, l)) {
				return 1 + leftCount + rightCount;
			}
			leftCount++;
			// processing right queue.
			if (processNode(qRight, visitedRight, adj, visitedLeft, l)) {
				return 1 + leftCount + rightCount;
			}
			rightCount++;
		}
		return 0;
	}

	private boolean processNode(ArrayDeque<String> q, Map<String, Boolean> visited, Map<String, List<String>> adj,
			Map<String, Boolean> otherVisited, int l) {
		int size = q.size();
		for (int j = 0; j < size; j++) {
			String poppedWord = q.poll();
			if (visited.get(poppedWord) && otherVisited.get(poppedWord)) {
				return true;
			}
			for (int i = 0; i < l; i++) {
				String newWord = poppedWord.substring(0, i) + "*" + poppedWord.substring(i + 1, l);
				List<String> childs = adj.getOrDefault(newWord, new ArrayList<>());
				for (int k = 0; k < childs.size(); k++) {
					String child = childs.get(k);
					if (!visited.get(child)) {
						q.offer(child);
						visited.put(child, true);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(
				"The number of words in shortest transormation sequence: " + wl.ladderLength("hit", "cog", wordList));
		System.out.println(
				"The number of words in shortest transormation sequence: " + wl.ladderLengthBi("hit", "cog", wordList));
	}

}
