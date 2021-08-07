package com.algorithms.practice.strings;

import java.util.Arrays;

public class ConstructLPSArray {

	// Given a string, you need to construct longest proper prefix suffix (LPS)
	// array.

	// naive implementation 1.
	public static int[] constructLpsNaive(String s) {
		int[] lps = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int maxLength = 0;
			int prefixIndex = i - 1;
			int suffixIndex = i;
			while (prefixIndex >= 0) {
				if (s.charAt(prefixIndex) == s.charAt(suffixIndex)) {
					prefixIndex--;
					suffixIndex--;
					maxLength += 1;
				} else {
					if (suffixIndex == i) {
						prefixIndex--;
					} else {
						suffixIndex = i;
					}
					maxLength = 0;
				}
			}
			lps[i] = maxLength;
		}
		return lps;
	}

	// naive implementation 2.
	public static int[] constructLpsNaive2(String s) {
		int[] lps = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int len = 0;
			for (len = i; len > 0; len--) {
				boolean isMatchFound = true;
				for (int j = 0; j < len; j++) {
					if (s.charAt(j) != s.charAt(i + 1 - len + j)) {
						isMatchFound = false;
						break;
					}
				}
				if (isMatchFound) {
					lps[i] = len;
					break;
				}
			}
			if (len == 0) {
				lps[i] = 0;
			}
		}
		return lps;
	}

	// efficient implementation.
	public static int[] constructLps(String s) {
		int[] lps = new int[s.length()];
		lps[0] = 0;
		int len = 0;
		for (int i = 1; i < s.length();) {
			if (s.charAt(len) == s.charAt(i)) {
				lps[i] = len + 1;
				len = lps[i];
				i++;
			} else {
				if (lps[i - 1] == 0 || len == 0) {
					lps[i] = 0;
					i++;
				} else {
					len = lps[len - 1];
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcbabca";
		System.out.println("The LPS Array is: " + Arrays.toString(constructLps(s)));
	}

}
