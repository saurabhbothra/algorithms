package com.algorithms.practice.strings;

public class RabinKarpAlgorithm {

	// Given a big text and a pattern, find the index of all occurrences of the
	// pattern in the text. If pattern does not exist, print "Not present".

	public static int d = 256;
	public static int q = 101;

	// efficient implementation for pattern searching, using Rabin Karp algorithm.
	public static void patternSearching(String pat, String text) {
		int numberOfWindows = text.length() - pat.length() + 1;
		int patternHashValue = 0;
		int windowHashValue = 0;
		int count = 0;
		int h = 1;
		for (int i = 1; i <= pat.length() - 1; i++) {
			h = (h * d) % q;
		}
		for (int i = 0; i < pat.length(); i++) {
			patternHashValue = (d * patternHashValue + pat.charAt(i)) % q;
			windowHashValue = (d * windowHashValue + text.charAt(i)) % q;
		}
		for (int i = 0; i < numberOfWindows; i++) {
			if (patternHashValue == windowHashValue) {
				boolean isPatternFound = true;
				for (int j = 0; j < pat.length(); j++) {
					if (text.charAt(i + j) != pat.charAt(j)) {
						isPatternFound = false;
						break;
					}
				}
				if (isPatternFound) {
					count++;
					System.out.print(i + " ");
				}
			}
			if (i < numberOfWindows - 1) {
				windowHashValue = (d * (windowHashValue - (h * text.charAt(i))) + text.charAt(i + pat.length())) % q;
				if (windowHashValue < 0) {
					windowHashValue = windowHashValue + q;
				}
			}
		}
		if (count == 0) {
			System.out.print("Pattern Not Present");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "AAAAA";
		String pat = "AAA";
		System.out.println("The indexes of all occurrences are:");
		patternSearching(pat, text);
	}

}
