package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathInAnUnweightedGraph {

	// Given an unweighted graph and a source point, the task is to find the
	// shortest path between the source point and every other point in the graph.

	public static int[] findShortestPathInAnUnweightedGraph(List<List<Integer>> adj, int source) {
		if (adj == null || adj.size() == 0) {
			return new int[] {};
		}
		int[] result = new int[adj.size()];
		boolean[] visited = new boolean[adj.size()];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			int poppedNode = q.poll();
			List<Integer> childs = adj.get(poppedNode);
			for (int node : childs) {
				if (!visited[node]) {
					result[node] = result[poppedNode] + 1;
					q.offer(node);
					visited[node] = true;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(0).add(4);

		adj.get(1).add(0);
		adj.get(1).add(3);

		adj.get(2).add(0);
		adj.get(2).add(3);
		adj.get(2).add(4);

		adj.get(3).add(1);
		adj.get(3).add(2);

		adj.get(4).add(0);
		adj.get(4).add(2);
		adj.get(4).add(5);

		adj.get(5).add(3);
		adj.get(5).add(4);

		System.out.println("The shortest path distances from source are: "
				+ Arrays.toString(findShortestPathInAnUnweightedGraph(adj, 0)));
	}

}
