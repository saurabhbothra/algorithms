package com.algorithms.practice.general;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

	// You have a graph of n nodes. You are given an integer n and an array edges
	// where edges[i] = [ai, bi] indicates that there is an edge between ai and bi
	// in the graph.

	// Return the number of connected components in the graph.

	// using dfs.
	public int countComponents(int n, int[][] edges) {
		Map<Integer, List<Integer>> hmap = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int des = edges[i][1];
			if (!hmap.containsKey(src)) {
				hmap.put(src, new ArrayList<>());
			}
			if (!hmap.containsKey(des)) {
				hmap.put(des, new ArrayList<>());
			}

			hmap.get(src).add(des);
			hmap.get(des).add(src);
		}
		int count = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				dfs(hmap, visited, i);
			}
		}
		return count;
	}

	private void dfs(Map<Integer, List<Integer>> hmap, boolean[] visited, int source) {
		visited[source] = true;
		if (hmap.containsKey(source)) {
			List<Integer> childs = hmap.get(source);
			if (childs.size() != 0) {
				for (Integer child : childs) {
					if (!visited[child]) {
						dfs(hmap, visited, child);
					}
				}
			}
		}
	}
}
