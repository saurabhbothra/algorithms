package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ReconstructItenary {

	// You are given a list of airline tickets where tickets[i] = [fromi, toi]
	// represent the departure and the arrival airports of one flight. Reconstruct
	// the itinerary in order and return it.

	// All of the tickets belong to a man who departs from "JFK", thus, the
	// itinerary must begin with "JFK". If there are multiple valid itineraries, you
	// should return the itinerary that has the smallest lexical order when read as
	// a single string.

	// For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
	// ["JFK", "LGB"].
	// You may assume all tickets form at least one valid itinerary. You must use
	// all the tickets once and only once.

	// dfs solution and topological sort.
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> hmap = new HashMap<>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String des = ticket.get(1);
			if (!hmap.containsKey(src)) {
				hmap.put(src, new PriorityQueue<>());
			}
			hmap.get(src).offer(des);
		}
		List<String> result = new ArrayList<>();
		ArrayDeque<String> st = new ArrayDeque<>();
		dfs(hmap, st, "JFK");
		while (!st.isEmpty()) {
			result.add(st.pop());
		}
		return result;
	}

	private void dfs(Map<String, PriorityQueue<String>> hmap, ArrayDeque<String> st, String source) {
		if (hmap.containsKey(source)) {
			PriorityQueue<String> pq = hmap.get(source);
			while (!pq.isEmpty()) {
				String child = pq.poll();
				dfs(hmap, st, child);
			}
		}
		st.push(source);
	}
}
