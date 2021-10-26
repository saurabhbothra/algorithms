package com.algorithms.practice.general;

public class ShortestWordDistance {

	// Given an array of strings wordsDict and two different strings that already
	// exist in the array word1 and word2, return the shortest distance between
	// these two words in the list.

	// wordsDict[i] consists of lowercase English letters.
	// word1 and word2 are in wordsDict.
	// word1 != word2

	// efficient solution.
	public static int shortestDistance(String[] wordsDict, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < wordsDict.length; i++) {
			String word = wordsDict[i];
			if (word.equals(word1)) {
				index1 = i;
			}
			if (word.equals(word2)) {
				index2 = i;
			}
			if (index1 != -1 && index2 != -1) {
				distance = Math.min(distance, Math.abs(index1 - index2));
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };
		System.out.println(
				"The shortest distance between two words is: " + shortestDistance(wordsDict, "makes", "coding"));
	}

}
