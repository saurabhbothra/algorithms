package com.algorithms.practice.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LexicographicRankOfAString {

	// Given a string, find the lexicographic rank of a string.
	// All characters are lowercase english alphabets.

	public int count = 0;

	// naive solution.
	public int lexicographicRankNaive(String S) {
		String temp = new String(S);
		char[] ch = S.toCharArray();
		Arrays.sort(ch);
		for (int i = 1; i < ch.length; i++) {
			if (ch[i - 1] == ch[i]) {
				return 0;
			}
		}
		S = String.valueOf(ch);
		return findRankRec(S, temp, 0) % 1000000007;
	}

	// helper method to do recursion.
	public int findRankRec(String S, String temp, int level) {
		if (level == S.length()) {
			count++;
			if (S.equals(temp)) {
				return count;
			}
			return -1;
		}
		int rank = 0;
		for (int i = level; i < S.length(); i++) {
			char[] ch = S.toCharArray();
			char t = ch[level];
			ch[level] = ch[i];
			ch[i] = t;
			S = String.valueOf(ch);
			rank = findRankRec(S, temp, level + 1);
			if (rank != -1) {
				break;
			}
		}
		return rank;
	}

	// efficient solution.
	public long lexicographicRank(String S) {
		long res = 0;
		long fact = 1;
		int[] chArr = new int[26];
		int[] factArr = new int[S.length()];
		Map<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			if (chArr[S.charAt(i) - 'a'] == 0) {
				chArr[S.charAt(i) - 'a'] = 1;
			} else {
				return 0;
			}
		}
		for (int i = 0; i < factArr.length; i++) {
			fact = (fact * (i + 1)) % 1000000007;
			factArr[i] = (int) fact;
		}
		for (int i = 0; i < S.length(); i++) {
			int sum = 0;
			int index = S.charAt(i) - 'a';
			for (int j = 0; j < 26; j++) {
				if (j < index) {
					sum = sum + chArr[j];
				} else {
					break;
				}
			}
			chArr[index] = 0;
			hmap.put(S.charAt(i), sum);
		}
		int len = S.length();
		for (int i = 0; i < S.length(); i++) {
			if (len >= 2) {
				res = (res + (hmap.get(S.charAt(i)) * (long) factArr[len - 2])) % 1000000007;
			} else {
				res = (res + (hmap.get(S.charAt(i)) * 1)) % 1000000007;
			}
			len--;
		}
		return (res + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LexicographicRankOfAString lrs = new LexicographicRankOfAString();
		String s = "string";
		System.out.println("The lexicographic rank of given string is: " + lrs.lexicographicRank(s));
	}

}
