package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GraphValidTree {

	// You have a graph of n nodes labeled from 0 to n - 1. You are given an integer
	// n and a list of edges where edges[i] = [ai, bi] indicates that there is an
	// undirected edge between nodes ai and bi in the graph.

	// Return true if the edges of the given graph make up a valid tree, and false
	// otherwise.

	// using dfs.
	public boolean validTree(int n, int[][] edges) {
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
				if (!dfs(hmap, visited, i, -1)) {
					return false;
				}
			}
		}
		return count == 1;
	}

	private boolean dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int source, int parent) {
		visited[source] = true;
		if (adj.containsKey(source)) {
			List<Integer> childs = adj.get(source);
			if (childs.size() != 0) {
				for (Integer child : childs) {
					if (!visited[child]) {
						if (!dfs(adj, visited, child, source)) {
							return false;
						}
					} else if (child != parent) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
