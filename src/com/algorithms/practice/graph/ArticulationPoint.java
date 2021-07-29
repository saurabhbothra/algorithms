package com.algorithms.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

	// Given an undirected and connected graph, you need to print articulation
	// points in the graph.

	// efficient implementation for articulation point.
	public static void findArticulationPoints(List<List<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		int[] discoveryTimes = new int[V];
		int[] lowValues = new int[V];
		boolean[] ap = new boolean[V];
		parent[0] = -1;
		int timer = 1;
		dfsRec(adj, visited, parent, ap, discoveryTimes, lowValues, timer, 0);
		for (int i = 0; i < V; i++) {
			if (ap[i]) {
				System.out.print(i + " ");
			}
		}
	}

	// helper method to do dfs.
	public static void dfsRec(List<List<Integer>> adj, boolean[] visited, int[] parent, boolean[] ap,
			int[] discoveryTimes, int[] lowValues, int timer, int source) {
		int children = 0;
		visited[source] = true;
		discoveryTimes[source] = timer;
		lowValues[source] = timer;
		timer++;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				children++;
				parent[node] = source;
				dfsRec(adj, visited, parent, ap, discoveryTimes, lowValues, timer, node);
				if (parent[source] == -1 && children > 1) {
					ap[source] = true;
				}
				if (parent[source] != -1 && lowValues[node] >= discoveryTimes[source]) {
					ap[source] = true;
				}
				lowValues[source] = Math.min(lowValues[source], lowValues[node]);
			} else if (visited[node] && parent[source] != node) {
				lowValues[source] = Math.min(lowValues[source], discoveryTimes[node]);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();
		int V = 5;
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		List<Integer> edge0 = adj.get(0);
		edge0.add(1);
		edge0.add(2);
		List<Integer> edge1 = adj.get(1);
		edge1.add(0);
		edge1.add(2);
		List<Integer> edge2 = adj.get(2);
		edge2.add(0);
		edge2.add(1);
		edge2.add(3);
		edge2.add(4);
		List<Integer> edge3 = adj.get(3);
		edge3.add(2);
		edge3.add(4);
		List<Integer> edge4 = adj.get(4);
		edge4.add(2);
		edge4.add(3);
		System.out.println("Articulation points for this graph are:");
		findArticulationPoints(adj, V);
	}

}
