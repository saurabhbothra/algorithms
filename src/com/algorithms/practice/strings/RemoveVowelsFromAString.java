package com.algorithms.practice.strings;

public class RemoveVowelsFromAString {

	// Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and
	// return the new string.
	// s consists of only lowercase English letters.

	// efficient implementation.
	public static String removeVowels(String s) {
		int[] arr = new int[26];
		StringBuilder sb = new StringBuilder();
		arr['e' - 'a'] = 1;
		arr[0] = 1;
		arr['i' - 'a'] = 1;
		arr['o' - 'a'] = 1;
		arr['u' - 'a'] = 1;
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 0) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcodeisacommunityforcoders";
		System.out.println("The modified string is: " + removeVowels(s));
	}

}
