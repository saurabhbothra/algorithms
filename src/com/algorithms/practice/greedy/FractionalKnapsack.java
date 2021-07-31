package com.algorithms.practice.greedy;

import java.util.Arrays;

public class FractionalKnapsack {

	// Given weights and values of N items, we need to put these items in a knapsack
	// of capacity W to get the maximum total value in the knapsack.
	// Note: Unlike 0/1 knapsack, you are allowed to break the item.

	// efficient implementation.
	double fractionalKnapsack(int W, Item arr[], int n) {
		Arrays.sort(arr, (i1, i2) -> Double.compare(-i1.value / (double) i1.weight, -i2.value / (double) i2.weight));
		double res = 0;
		for (int i = 0; i < arr.length; i++) {
			Item it = arr[i];
			if (it.weight <= W) {
				W = W - it.weight;
				res += it.value;
			} else {
				int rem = W;
				W = 0;
				res += rem * (it.value / (double) it.weight);
			}
			if (W == 0) {
				break;
			}
		}
		return res;
	}

}

class Item {
	int value;
	int weight;

	Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}
