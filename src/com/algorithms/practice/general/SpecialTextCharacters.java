package com.algorithms.practice.general;

import java.util.HashMap;
import java.util.Map;

public class SpecialTextCharacters {

	// A string consists of '[', ']', '(', ')', '?' as characters and we need to
	// split string into two halves in such a way that the two string are perfectly
	// balanced. '?' acts as joker if it exists in that half, which can be used in
	// place of other characters to make that half balanced.

	// Return the total number of splits that is possible.

	// efficient solution.
	public static int getSplits(String s) {
		Map<Character, Integer> hmap = new HashMap<>();
		Map<Character, Integer> leftMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
		}
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			leftMap.put(s.charAt(i), leftMap.getOrDefault(s.charAt(i), 0) + 1);
			hmap.put(s.charAt(i), hmap.get(s.charAt(i)) - 1);
			if (validate(hmap) && validate(leftMap)) {
				count++;
			}
		}

		return count;
	}

	public static boolean validate(Map<Character, Integer> hmap) {
		int openSquare = 0;
		int closeSquare = 0;
		int openRound = 0;
		int closeRound = 0;
		int joker = 0;
		if (hmap.containsKey('[')) {
			openSquare = hmap.get('[');
		}
		if (hmap.containsKey(']')) {
			closeSquare = hmap.get(']');
		}
		if (hmap.containsKey('(')) {
			openRound = hmap.get('(');
		}
		if (hmap.containsKey(')')) {
			closeRound = hmap.get(')');
		}
		if (hmap.containsKey('?')) {
			joker = hmap.get('?');
		}
		int value = Math.abs(openSquare - closeSquare) + Math.abs(openRound - closeRound);
		if (value == joker) {
			return true;
		}
		if (joker > value && (joker - value) % 2 == 0) {
			return true;
		}
		if (openSquare - closeSquare == 0 && openRound - closeRound == 0 && joker % 2 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "))?)?)?))?())()(??(?((())(?)?())((((()(?";
		String s1 = "[(?][??[";
		System.out.println(getSplits(s));
		System.out.println(getSplits(s1));
	}

}
