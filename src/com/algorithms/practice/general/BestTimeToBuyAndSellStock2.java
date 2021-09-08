package com.algorithms.practice.general;

public class BestTimeToBuyAndSellStock2 {

	// You are given an integer array prices where prices[i] is the price of a given
	// stock on the ith day.

	// On each day, you may decide to buy and/or sell the stock. You can only hold
	// at most one share of the stock at any time. However, you can buy it then
	// immediately sell it on the same day.

	// Find and return the maximum profit you can achieve.

	// greedy solution.
	public int maxProfitGreedy(int[] prices) {
		int maxProfit = 0;
		int buy = prices[0];
		int sell = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > sell) {
				sell = prices[i];
			} else {
				maxProfit = maxProfit + (sell - buy);
				buy = prices[i];
				sell = prices[i];
			}
		}
		maxProfit += sell - buy;
		return maxProfit;
	}

	// simple recursive solution.
	public int maxProfitSimple(int[] prices) {
		return stockRec(prices, 0);
	}

	private int stockRec(int[] prices, int index) {
		if (index == prices.length) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = index; i < prices.length; i++) {
			if (prices[i] >= prices[index]) {
				int subResult = (prices[i] - prices[index]) + stockRec(prices, i + 1);
				maxProfit = Math.max(maxProfit, subResult);
			}
		}
		return maxProfit;
	}

	// memoization.
	public int maxProfitMemo(int[] prices) {
		Integer[] memo = new Integer[prices.length + 1];
		return stockRec(prices, 0, memo);
	}

	private int stockRec(int[] prices, int index, Integer[] memo) {
		if (index == prices.length) {
			memo[index] = 0;
		}
		if (memo[index] == null) {
			int maxProfit = 0;
			for (int i = index; i < prices.length; i++) {
				if (prices[i] >= prices[index]) {
					int subResult = (prices[i] - prices[index]) + stockRec(prices, i + 1, memo);
					maxProfit = Math.max(maxProfit, subResult);
				}
			}
			memo[index] = maxProfit;
		}
		return memo[index];
	}

	// tabulation.
	public int maxProfitTabulation(int[] prices) {
		int[] dp = new int[prices.length + 1];
		dp[prices.length] = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			int maxProfit = 0;
			for (int j = i; j < prices.length; j++) {
				if (prices[j] >= prices[i]) {
					int subResult = (prices[j] - prices[i]) + dp[j + 1];
					maxProfit = Math.max(maxProfit, subResult);
				}
			}
			dp[i] = maxProfit;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStock2 bt = new BestTimeToBuyAndSellStock2();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitGreedy(prices));
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitSimple(prices));
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitMemo(prices));
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitTabulation(prices));
	}

}
