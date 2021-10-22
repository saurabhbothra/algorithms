package com.algorithms.practice.strings;

import java.util.ArrayDeque;

public class ReverseWordsInAString {

	// Given an input string s, reverse the order of the words.

	// A word is defined as a sequence of non-space characters. The words in s will
	// be separated by at least one space.

	// Return a string of the words in reverse order concatenated by a single space.

	// Note that s may contain leading or trailing spaces or multiple spaces between
	// two words. The returned string should only have a single space separating the
	// words. Do not include any extra spaces.

	// naive solution.
	public static String reverseWordsNaive(String s) {
		s = s.trim();
		ArrayDeque<String> st = new ArrayDeque<>();
		String[] arr = s.split("\\s+");
		for (String str : arr) {
			if (str != "") {
				st.push(str);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
			if (!st.isEmpty()) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	// efficient implementation.
	public static String reverseWordsEfficeint(String s) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = s.length() - 1;
		while (s.charAt(start) == ' ') {
			start++;
		}
		while (s.charAt(end) == ' ') {
			end--;
		}
		boolean isSpace = false;
		int wordEnd = end;
		for (int i = end; i >= start; i--) {
			char ch = s.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				wordEnd = Math.max(wordEnd, i);
				isSpace = false;
			} else {
				if (!isSpace) {
					sb.append(s.substring(i + 1, wordEnd + 1));
					wordEnd = Integer.MIN_VALUE;
					isSpace = true;
					sb.append(" ");
				}
			}
		}
		sb.append(s.substring(start, wordEnd + 1));
		return sb.toString();
	}

	// efficient implementation 2.
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = s.length() - 1;
		while (s.charAt(i) == ' ') {
			i++;
		}
		while (s.charAt(j) == ' ') {
			j--;
		}
		while (j >= i) {
			int end = j;
			while (j >= i && s.charAt(j) != ' ') {
				j--;
			}
			sb.append(s.substring(j + 1, end + 1));
			if (j < i) {
				break;
			}
			while (s.charAt(j) == ' ') {
				j--;
			}
			sb.append(' ');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  hello world  ";
		System.out.println("The reversed string is: " + reverseWordsNaive(s));
	}

}
