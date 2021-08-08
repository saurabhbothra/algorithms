package com.algorithms.practice.strings;

public class KMPAlgorithm {

	// Given a big text and a pattern, find the index of all occurrences of the
	// pattern in the text. If pattern does not exist, print "Not present".

	// efficient implementation using kmp algorithm.
	public static void patternSearching(String pat, String text) {
		int n = text.length();
		int m = pat.length();
		int count = 0;
		int i = 0;
		int j = 0;
		int[] lps = ConstructLPSArray.constructLps(pat);
		while (i < n) {
			if (text.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				count++;
				System.out.print(i - j + " ");
				j = lps[j - 1];
			} else if (i < n && text.charAt(i) != pat.charAt(j)) {
				if (j == 0) {
					i++;
				} else {
					j = lps[j - 1];
				}
			}
		}
		if (count == 0) {
			System.out.print("Pattern Not Found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "aaaaa";
		String pat = "aaa";
		System.out.println("The indexes of all occurrences are:");
		patternSearching(pat, text);
	}

}
