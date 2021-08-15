package com.algorithms.practice.dp;

public class EditDistance {

	// Given two strings word1 and word2, return the minimum number of operations
	// required to convert word1 to word2.

	// You have the following three operations permitted on a word:

	// Insert a character
	// Delete a character
	// Replace a character

	// 0 <= word1.length, word2.length <= 500
	// word1 and word2 consist of lowercase English letters.

	// simple recursive solution.
	public int minDistanceSimple(String word1, String word2) {
		return editRec(word1, word2, word1.length(), word2.length());
	}

	// helper method to do naive recursion.
	public int editRec(String word1, String word2, int n, int m) {
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}

		if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
			return editRec(word1, word2, n - 1, m - 1);
		}

		int insertCount = editRec(word1, word2, n, m - 1);
		int deleteCount = editRec(word1, word2, n - 1, m);
		int replaceCount = editRec(word1, word2, n - 1, m - 1);
		int opMin = Math.min(Math.min(insertCount, deleteCount), replaceCount);
		return 1 + opMin;
	}

	// memoization.
	public int minDistanceMemo(String word1, String word2) {
		Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
		return editRec(word1, word2, word1.length(), word2.length(), memo);
	}

	// helper method to do memoization.
	public int editRec(String word1, String word2, int n, int m, Integer[][] memo) {
		if (n == 0) {
			memo[n][m] = m;
		} else if (m == 0) {
			memo[n][m] = n;
		}

		if (memo[n][m] == null) {
			if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
				memo[n][m] = editRec(word1, word2, n - 1, m - 1, memo);
			} else {
				int insertCount = editRec(word1, word2, n, m - 1, memo);
				int deleteCount = editRec(word1, word2, n - 1, m, memo);
				int replaceCount = editRec(word1, word2, n - 1, m - 1, memo);
				int opMin = Math.min(Math.min(insertCount, deleteCount), replaceCount);
				memo[n][m] = 1 + opMin;
			}
		}
		return memo[n][m];
	}

	// tabulation.
	public int minDistanceTabulation(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		String word1 = "horse";
		String word2 = "ros";
		System.out.println("The minimum number of operations required is: " + ed.minDistanceTabulation(word1, word2));
	}

}
