package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GenerateParanthesis {

	// Given n pairs of parentheses, write a function to generate all combinations
	// of well-formed parentheses.

	// 1 <= n <= 8

	// simple recursive solution.
	public List<String> generateParenthesisSimple(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0) {
			result.add("");
		} else if (n == 1) {
			result.add("()");
		} else {
			for (int i = 0; i < n; i++) {
				List<String> nest = generateParenthesisSimple(i);
				List<String> join = generateParenthesisSimple(n - i - 1);
				for (String nst : nest) {
					String temp = "(" + nst + ")";
					for (String j : join) {
						result.add(temp + j);
					}
				}
			}
		}
		return result;
	}

	// memoization.
	public List<String> generateParenthesisMemo(int n) {
		Map<Integer, List<String>> memo = new HashMap<>();
		return generateRec(n, memo);
	}

	private List<String> generateRec(int n, Map<Integer, List<String>> memo) {
		if (memo.get(n) == null) {
			List<String> result = new ArrayList<>();
			memo.put(n, result);
			if (n == 0) {
				result.add("");
			} else if (n == 1) {
				result.add("()");
			} else {
				for (int i = 0; i < n; i++) {
					List<String> nest = generateRec(i, memo);
					List<String> join = generateRec(n - i - 1, memo);
					for (String nst : nest) {
						String temp = "(" + nst + ")";
						for (String j : join) {
							result.add(temp + j);
						}
					}
				}
			}
		}
		return memo.get(n);
	}

	// tabulation.
	public List<String> generateParenthesisTabulation(int n) {
		Map<Integer, List<String>> dp = new HashMap<>();
		dp.put(0, Arrays.asList(""));
		dp.put(1, Arrays.asList("()"));
		for (int i = 2; i <= n; i++) {
			List<String> result = new ArrayList<>();
			dp.put(i, result);
			for (int j = 0; j < i; j++) {
				List<String> nest = dp.get(j);
				List<String> join = dp.get(i - j - 1);
				for (String nst : nest) {
					String temp = "(" + nst + ")";
					for (String jo : join) {
						result.add(temp + jo);
					}
				}
			}
		}
		return dp.get(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParanthesis gp = new GenerateParanthesis();
		System.out.println("All balanced combinations are:");
		List<String> result = gp.generateParenthesisTabulation(3);
		for (String s : result) {
			System.out.println(s);
		}
	}

}
