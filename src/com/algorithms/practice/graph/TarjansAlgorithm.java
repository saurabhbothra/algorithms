package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarjansAlgorithm {

	// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
	// print members of strongly connected components in the graph.

	public int timer;

	// efficient implementation of tarjans algorithm.
	public List<List<Integer>> findStronglyConnectedComponents(List<List<Integer>> adj, int V) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[V];
		int[] discoveryTimes = new int[V];
		int[] lowValues = new int[V];
		boolean[] stackMember = new boolean[V];
		ArrayDeque<Integer> st = new ArrayDeque<>();
		this.timer = 1;
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				this.dfsRec(adj, visited, discoveryTimes, lowValues, st, i, result, stackMember);
			}
		}
		for (List<Integer> component : result) {
			Collections.sort(component);
		}
		Collections.sort(result, (n1, n2) -> Integer.compare(n1.get(0), n2.get(0)));
		return result;
	}

	// helper method to do recursion.
	public void dfsRec(List<List<Integer>> adj, boolean[] visited, int[] discoveryTimes, int[] lowValues,
			ArrayDeque<Integer> st, int source, List<List<Integer>> result, boolean[] stackMember) {
		visited[source] = true;
		st.push(source);
		stackMember[source] = true;
		discoveryTimes[source] = this.timer;
		lowValues[source] = this.timer;
		this.timer++;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				dfsRec(adj, visited, discoveryTimes, lowValues, st, node, result, stackMember);
				lowValues[source] = Math.min(lowValues[source], lowValues[node]);
			} else if (visited[node] && stackMember[node]) {
				lowValues[source] = Math.min(lowValues[source], discoveryTimes[node]);
			}
		}
		if (discoveryTimes[source] == lowValues[source]) {
			List<Integer> component = new ArrayList<>();
			while (!st.isEmpty()) {
				Integer node = st.pop();
				stackMember[node] = false;
				component.add(node);
				if (node == source) {
					break;
				}
			}
			result.add(component);
		}
	}

}
