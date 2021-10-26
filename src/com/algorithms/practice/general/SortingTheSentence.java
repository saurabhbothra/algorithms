package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class SortingTheSentence {

	// A sentence is a list of words that are separated by a single space with no
	// leading or trailing spaces. Each word consists of lowercase and uppercase
	// English letters.

	// A sentence can be shuffled by appending the 1-indexed word position to each
	// word then rearranging the words in the sentence.

	// For example, the sentence "This is a sentence" can be shuffled as "sentence4
	// a3 is2 This1" or "is2 sentence4 This1 a3".

	// Given a shuffled sentence s containing no more than 9 words, reconstruct and
	// return the original sentence.

	// efficient solution.
	public static String sortSentence(String s) {
		String[] words = s.split(" ");
		Map<Integer, String> hmap = new HashMap<>();
		for (String word : words) {
			int index = Character.getNumericValue(word.charAt(word.length() - 1));
			String w = word.substring(0, word.length() - 1);
			hmap.put(index, w);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(hmap.get(1));
		for (int i = 2; i <= words.length; i++) {
			sb.append(" ");
			sb.append(hmap.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "is2 sentence4 This1 a3";
		System.out.println("The sorted sentence is: " + sortSentence(s));
	}

}
