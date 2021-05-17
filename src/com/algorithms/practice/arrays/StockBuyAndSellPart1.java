package com.algorithms.practice.arrays;

public class StockBuyAndSellPart1 {

	// You are given an array prices where prices[i] is the price of a given stock
	// on the ith day.

	// Find the maximum profit you can achieve. You may complete as many
	// transactions as you like (i.e., buy one and sell one share of the stock
	// multiple times).

	// Note: You may not engage in multiple transactions simultaneously (i.e., you
	// must sell the stock before you buy again).

	// 1 <= prices.length <= 3 * 10^4

	// efficient solution.
	public static int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit = profit + prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int[] prices1 = { 1, 2, 3, 4, 5 };
		int[] prices2 = { 7, 6, 4, 3, 1 };
		System.out.println("The maximum profit for these prices is: " + maxProfit(prices));
		System.out.println("The maximum profit for these prices is: " + maxProfit(prices1));
		System.out.println("The maximum profit for these prices is: " + maxProfit(prices2));
	}

}
