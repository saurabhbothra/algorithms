package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LetterCombinationsOfAPhoneNumber {

	// Given a string containing digits from 2-9 inclusive, return all possible
	// letter combinations that the number could represent. Return the answer in any
	// order.

	// A mapping of digit to letters (just like on the telephone buttons) is given
	// below. Note that 1 does not map to any letters.

	// 0 <= digits.length <= 4
	// digits[i] is a digit in the range ['2', '9'].

	// recursion with backtracking.
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.equals("")) {
			return result;
		}
		Map<Character, List<Character>> hmap = new HashMap<>();
		char letter = 'a';
		int temp = 3;
		for (char ch = '2'; ch <= '9'; ch++) {
			hmap.put(ch, new ArrayList<>());
			if (ch == '7' || ch == '9') {
				temp = 4;
			} else {
				temp = 3;
			}
			for (int i = 0; i < temp; i++) {
				hmap.get(ch).add(letter);
				letter++;
			}
		}
		letterRec(digits, 0, result, "", hmap);
		return result;
	}

	private void letterRec(String digits, int index, List<String> result, String combination,
			Map<Character, List<Character>> hmap) {
		if (index == digits.length()) {
			result.add(combination);
			return;
		}
		List<Character> mappings = hmap.get(digits.charAt(index));
		for (char ch : mappings) {
			letterRec(digits, index + 1, result, combination + ch, hmap);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The letter combinatins of a phone number are:");
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
		List<String> result = lc.letterCombinations("23");
		for (String s : result) {
			System.out.println(s);
		}
	}

}
