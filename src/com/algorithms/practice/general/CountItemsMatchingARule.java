package com.algorithms.practice.general;

import java.util.List;

public class CountItemsMatchingARule {

	// You are given an array items, where each items[i] = [typei, colori, namei]
	// describes the type, color, and name of the ith item. You are also given a
	// rule represented by two strings, ruleKey and ruleValue.

	// The ith item is said to match the rule if one of the following is true:

	// ruleKey == "type" and ruleValue == typei.
	// ruleKey == "color" and ruleValue == colori.
	// ruleKey == "name" and ruleValue == namei.
	// Return the number of items that match the given rule.

	// efficient solution.
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int count = 0;
		for (List<String> item : items) {
			if ((ruleKey.equals("type") && ruleValue.equals(item.get(0)))
					|| (ruleKey.equals("color") && ruleValue.equals(item.get(1)))
					|| (ruleKey.equals("name") && ruleValue.equals(item.get(2)))) {
				count++;
			}
		}
		return count;
	}

}
