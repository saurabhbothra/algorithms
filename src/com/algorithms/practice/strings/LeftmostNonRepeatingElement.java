package com.algorithms.practice.strings;

public class LeftmostNonRepeatingElement {

	// Given a string s, find the first non-repeating character in it and return its
	// index. If it does not exist, return -1.

	// s consists of only lowercase English letters.

	// efficient implementation, two traversals of string.
	public static int firstUniqChar(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			arr[ch - 'a'] += 1;
		}
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 1) {
				index = i;
				break;
			}
		}
		return index;
	}

	// efficient implementation, one traversal of string.
	public static int firstUniqCharEfficient(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;
			} else {
				arr[ch - 'a'] = -2;
			}
		}
		int index = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (arr[i] != -1 && arr[i] != -2) {
				index = Math.min(index, arr[i]);
			}
		}
		return (index == Integer.MAX_VALUE) ? -1 : index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		System.out.println("The index of leftmost non repeating character is: " + firstUniqCharEfficient(s));
	}

}
