package com.algorithms.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {

	// You are given an array of logs. Each log is a space-delimited string of
	// words, where the first word is the identifier.

	// There are two types of logs:

	// Letter-logs: All words (except the identifier) consist of lowercase English
	// letters.

	// Digit-logs: All words (except the identifier) consist of digits.

	// Reorder these logs so that:

	// The letter-logs come before all digit-logs.

	// The letter-logs are sorted lexicographically by their contents. If their
	// contents are the same, then sort them lexicographically by their identifiers.

	// The digit-logs maintain their relative ordering.

	// Return the final order of the logs.

	// solution.
	public static String[] reorderLogFiles(String[] logs) {
		String[] result = new String[logs.length];
		List<Node> letterLogs = new ArrayList<>();
		int index = logs.length - 1;
		for (int i = logs.length - 1; i >= 0; i--) {
			String temp = logs[i];
			if (Character.isDigit(temp.charAt(temp.length() - 1))) {
				result[index] = temp;
				index--;
			} else {
				int sp = temp.indexOf(" ");
				Node node = new Node(temp.substring(0, sp), temp.substring(sp + 1, temp.length()));
				letterLogs.add(node);
			}
		}

		Collections.sort(letterLogs, (n1, n2) -> n1.identifier.compareTo(n2.identifier));
		Collections.sort(letterLogs, (n1, n2) -> n1.words.compareTo(n2.words));
		index = 0;
		for (Node n : letterLogs) {
			result[index] = n.identifier + " " + n.words;
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		System.out.println("The reordered data is: ");
		System.out.println(Arrays.toString(reorderLogFiles(logs)));
	}

}

class Node {
	String identifier;
	String words;

	Node(String identifier, String words) {
		this.identifier = identifier;
		this.words = words;
	}
}
