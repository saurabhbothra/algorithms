package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

class GNode {
	public int val;
	public List<GNode> neighbors;

	public GNode(int _val) {
		val = _val;
		neighbors = new ArrayList<>();
	}
}

public class CloneAGraph {

	// Given a reference of a node in a connected undirected graph.

	// Return a deep copy (clone) of the graph.

	// Each node in the graph contains a value (int) and a list (List[Node]) of its
	// neighbors.

	// bfs solution.
	public GNode cloneGraph(GNode node) {
		if (node == null) {
			return null;
		}
		Set<GNode> hset = new HashSet<>();
		Map<GNode, GNode> newMap = new HashMap<>();
		newMap.put(node, new GNode(node.val));
		ArrayDeque<GNode> q = new ArrayDeque<>();
		q.offer(node);
		hset.add(node);
		while (!q.isEmpty()) {
			GNode poppedNode = q.poll();
			List<GNode> childs = poppedNode.neighbors;
			for (GNode child : childs) {
				if (!hset.contains(child)) {
					newMap.put(child, new GNode(child.val));
					hset.add(child);
					q.offer(child);
				}
				newMap.get(poppedNode).neighbors.add(newMap.get(child));
			}
		}
		return newMap.get(node);
	}

	// dfs solution.
	public GNode cloneGraphDFS(GNode node) {
		if (node == null) {
			return null;
		}
		Set<GNode> visited = new HashSet<>();
		Map<GNode, GNode> hmap = new HashMap<>();
		dfs(node, visited, hmap);
		return hmap.get(node);
	}

	private void dfs(GNode node, Set<GNode> visited, Map<GNode, GNode> hmap) {
		visited.add(node);
		hmap.put(node, new GNode(node.val));
		List<GNode> childs = node.neighbors;
		for (GNode child : childs) {
			if (!visited.contains(child)) {
				dfs(child, visited, hmap);
			}
			hmap.get(node).neighbors.add(hmap.get(child));
		}
	}

}
