package com.algorithms.practice.general;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AnalyzeUserWebsiteVisitPattern {

	// You are given two string arrays username and website and an integer array
	// timestamp. All the given arrays are of the same length and the tuple
	// [username[i], website[i], timestamp[i]] indicates that the user username[i]
	// visited the website website[i] at time timestamp[i].

	// A pattern is a list of three websites (not necessarily distinct).

	// For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and
	// ["luffy", "luffy", "luffy"] are all patterns.

	// The score of a pattern is the number of users that visited all the websites
	// in the pattern in the same order they appeared in the pattern.

	// For example, if the pattern is ["home", "away", "love"], the score is the
	// number of users x such that x visited "home" then visited "away" and visited
	// "love" after that.

	// Similarly, if the pattern is ["leetcode", "love", "leetcode"], the score is
	// the number of users x such that x visited "leetcode" then visited "love" and
	// visited "leetcode" one more time after that.

	// Also, if the pattern is ["luffy", "luffy", "luffy"], the score is the number
	// of users x such that x visited "luffy" three different times at different
	// timestamps.

	// Return the pattern with the largest score. If there is more than one pattern
	// with the same largest score, return the lexicographically smallest such
	// pattern.

	// It is guaranteed that there is at least one user who visited at least three
	// websites.
	// All the tuples [username[i], timestamp[i], website[i]] are unique.

	// solution, using two maps.
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, Map<Integer, String>> hmap = new HashMap<>();
		Map<String, Integer> sequences = new TreeMap<>();
		for (int i = 0; i < username.length; i++) {
			if (!hmap.containsKey(username[i])) {
				hmap.put(username[i], new TreeMap<>());
			}
			hmap.get(username[i]).put(timestamp[i], website[i]);
		}
		for (String user : hmap.keySet()) {
			generateSubsets(new ArrayList<>(hmap.get(user).values()), new HashSet<>(), sequences);
		}
		int maxValue = 0;
		String seq = "";
		for (String entry : sequences.keySet()) {
			if (sequences.get(entry) > maxValue) {
				maxValue = sequences.get(entry);
				seq = entry;
			}
		}
		String[] result = seq.split(",");
		return Arrays.asList(result);
	}

	public void generateSubsets(List<String> pattern, Set<String> hset, Map<String, Integer> sequences) {
		for (int i = 0; i < pattern.size(); i++) {
			for (int j = i + 1; j < pattern.size(); j++) {
				for (int k = j + 1; k < pattern.size(); k++) {
					String seq = String.join(",", Arrays.asList(pattern.get(i), pattern.get(j), pattern.get(k)));
					if (!hset.contains(seq)) {
						hset.add(seq);
						sequences.put(seq, sequences.getOrDefault(seq, 0) + 1);
					}
				}
			}
		}
	}
}
