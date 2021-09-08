package com.algorithms.practice.general;

public class BestTimeToBuyAndSellStock3 {

	// You are given an array prices where prices[i] is the price of a given stock
	// on the ith day.

	// Find the maximum profit you can achieve. You may complete at most two
	// transactions.

	// Note: You may not engage in multiple transactions simultaneously (i.e., you
	// must sell the stock before you buy again).

	// simple recursive solution.
	public int maxProfitSimple(int[] prices) {
		return stockRec(prices, 0, 2);
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

	// Idea.
	// A naive implementation of the above idea would be to divide the sequences
	// into two and then enumerate each of the subsequences, though this is
	// definitely not the most optimized solution.

	// For a sequence of length N, we would have N possible divisions (including no
	// division), each of the elements would be visited once in each division. As a
	// result, the overall time complexity of this naive implementation would be
	// O(N^2)

	// Regarding the algorithms of divide-and-conquer, one common technique that we
	// can apply in order to optimize the time complexity is called dynamic
	// programming (DP) where we trade less repetitive calculation with some extra
	// space.

	// In dynamic programming algorithms, normally we create an array of one or two
	// dimensions to keep the intermediate optimal results. In this problem though,
	// we would use two arrays, with one array keeping the results of sequence from
	// left to right and the other array keeping the results of sequence from right
	// to left. For the sake of name, we could call it bidirectional dynamic
	// programming.

	// bidirectional dynamic programming.
	public int maxProfitBiDp(int[] prices) {
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		left[0] = 0;
		right[prices.length - 1] = 0;
		int leftMaxProfit = 0;
		int leftMin = prices[0];

		// processing left array.
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < leftMin) {
				leftMin = prices[i];
			} else {
				int temp = prices[i] - leftMin;
				if (temp > leftMaxProfit) {
					leftMaxProfit = temp;
				}
			}
			left[i] = leftMaxProfit;
		}

		// processing right array.
		int rightMax = prices[prices.length - 1];
		int rightMaxProfit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > rightMax) {
				rightMax = prices[i];
			} else {
				int temp = rightMax - prices[i];
				if (temp > rightMaxProfit) {
					rightMaxProfit = temp;
				}
			}
			right[i] = rightMaxProfit;
		}

		int maxProfit = left[prices.length - 1];
		for (int i = 0; i < prices.length - 1; i++) {
			maxProfit = Math.max(maxProfit, left[i] + right[i + 1]);
		}

		return maxProfit;
	}

	// Idea.
	// To solve the game, we simply run a simulation along the sequence of prices,
	// at each time step, we calculate the potential outcomes for each of our
	// actions. At the end of the simulation, the outcome of the final action "sell
	// of transaction #2" would be the desired output of the problem.

	// one pass simulation.
	public int maxProfitOnePass(int[] prices) {
		int firstBuy = Integer.MAX_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MAX_VALUE;
		int secondSell = 0;
		for (int i : prices) {
			firstBuy = Math.min(firstBuy, i);
			firstSell = Math.max(firstSell, i - firstBuy);
			secondBuy = Math.min(secondBuy, i - firstSell);
			secondSell = Math.max(secondSell, i - secondBuy);
		}
		return secondSell;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStock3 bt = new BestTimeToBuyAndSellStock3();
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitSimple(prices));
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitBiDp(prices));
		System.out.println("The maximum profit you can achieve is: " + bt.maxProfitOnePass(prices));
	}

}
