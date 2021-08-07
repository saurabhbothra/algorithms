package com.algorithms.practice.strings;

public class NaivePatternSearchingWithDistinctCharacters {

	// Given a big text and a pattern with distinct characters, find the index of
	// all occurrences of the
	// pattern in the text. If pattern does not exist, print "Not present".

	// improved naive implementation.
	public static void patternSearching(String pat, String text) {
		int noOfWindows = text.length() - pat.length() + 1;
		int count = 0;
		for (int i = 0; i < noOfWindows;) {
			boolean isPatternFound = true;
			int j = 0;
			for (j = 0; j < pat.length(); j++) {
				if (pat.charAt(j) != text.charAt(i + j)) {
					isPatternFound = false;
					break;
				}
			}
			if (isPatternFound) {
				count++;
				System.out.print(i + " ");
			}
			if (j == 0) {
				i++;
			} else {
				i = i + j;
			}
		}
		if (count == 0) {
			System.out.print("Pattern Not Present");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "GEEKSFORGEEKS";
		String pat = "EKS";
		System.out.println("The indexes of all occurrences are:");
		patternSearching(pat, text);
	}

}
