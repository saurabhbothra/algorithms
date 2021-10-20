package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class SingleRowKeyboard {

	// There is a special keyboard with all keys in a single row.

	// Given a string keyboard of length 26 indicating the layout of the keyboard
	// (indexed from 0 to 25). Initially, your finger is at index 0. To type a
	// character, you have to move your finger to the index of the desired
	// character. The time taken to move your finger from index i to index j is |i -
	// j|.

	// You want to type a string word. Write a function to calculate how much time
	// it takes to type it with one finger.

	// keyboard contains each English lowercase letter exactly once in some order.

	// word[i] is an English lowercase letter.

	// efficient solution.
	public static int calculateTime(String keyboard, String word) {
		Map<Character, Integer> hmap = new HashMap<>();
		for (int i = 0; i < keyboard.length(); i++) {
			hmap.put(keyboard.charAt(i), i);
		}
		int prev = 0;
		int time = 0;
		for (int i = 0; i < word.length(); i++) {
			int index = hmap.get(word.charAt(i));
			time += Math.abs(prev - index);
			prev = index;
		}
		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Time taken to type a word is: " + calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
	}

}
