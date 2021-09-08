package com.algorithms.practice.general;

public class BestTimeToBuyAndSellStock4 {

	// You are given an integer array prices where prices[i] is the price of a given
	// stock on the ith day, and an integer k.

	// Find the maximum profit you can achieve. You may complete at most k
	// transactions.

	// Note: You may not engage in multiple transactions simultaneously (i.e., you
	// must sell the stock before you buy again).

	// simple recursive solution.
	public int maxProfitSimple(int k, int[] prices) {
		return stockRec(prices, 0, k);
	}

	private int stockRec(int[] prices, int index, int k) {
		if (k == 0 || index == prices.length) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = index; i < prices.length; i++) {
			if (prices[i] > prices[index]) {
				int subResult = (prices[i] - prices[index]) + stockRec(prices, i + 1, k - 1);
				maxProfit = Math.max(maxProfit, subResult);
			}
		}
		maxProfit = Math.max(maxProfit, stockRec(prices, index + 1, k));
		return maxProfit;
	}

	// memoization.
	public int maxProfitMemo(int k, int[] prices) {
		Integer[][] memo = new Integer[k + 1][prices.length + 1];
		return stockRec(prices, 0, k, memo);
	}

	private int stockRec(int[] prices, int index, int k, Integer[][] memo) {
		if (k == 0 || index == prices.length) {
			memo[k][index] = 0;
		}
		if (memo[k][index] == null) {
			int maxProfit = 0;
			for (int i = index; i < prices.length; i++) {
				if (prices[i] > prices[index]) {
					int subResult = (prices[i] - prices[index]) + stockRec(prices, i + 1, k - 1, memo);
					maxProfit = Math.max(maxProfit, subResult);
				}
			}
			maxProfit = Math.max(maxProfit, stockRec(prices, index + 1, k, memo));
			memo[k][index] = maxProfit;
		}
		return memo[k][index];
	}

	// tabulation.
	public int maxProfitTabulation(int k, int[] prices) {
		int[][] dp = new int[k + 1][prices.length + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = prices.length - 1; j >= 0; j--) {
				int maxProfit = 0;
				for (int x = j; x < prices.length; x++) {
					if (prices[x] > prices[j]) {
						int subResult = (prices[x] - prices[j]) + dp[i - 1][x + 1];
						maxProfit = Math.max(maxProfit, subResult);
					}
				}
				maxProfit = Math.max(maxProfit, dp[i][j + 1]);
				dp[i][j] = maxProfit;
			}
		}
		return dp[k][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStock4 bt = new BestTimeToBuyAndSellStock4();
		int[] prices = { 2, 4, 1 };
		System.out.println("The maximum profit after k transactions is: " + bt.maxProfitSimple(2, prices));
		System.out.println("The maximum profit after k transactions is: " + bt.maxProfitMemo(2, prices));
		System.out.println("The maximum profit after k transactions is: " + bt.maxProfitTabulation(2, prices));
	}

}
