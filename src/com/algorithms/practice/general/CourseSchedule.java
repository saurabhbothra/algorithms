package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CourseSchedule {

	// There are a total of numCourses courses you have to take, labeled from 0 to
	// numCourses - 1. You are given an array prerequisites where prerequisites[i] =
	// [ai, bi] indicates that you must take course bi first if you want to take
	// course ai.

	// For example, the pair [0, 1], indicates that to take course 0 you have to
	// first take course 1.

	// Return true if you can finish all courses. Otherwise, return false.

	// All the pairs prerequisites[i] are unique.

	// solution using topological sort using kahn's algorithm.
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int independentCourse = prerequisites[i][1];
			int dependentCourse = prerequisites[i][0];
			inDegree[dependentCourse] = inDegree[dependentCourse] + 1;
			if (!adj.containsKey(independentCourse)) {
				adj.put(independentCourse, new ArrayList<>());
			}
			adj.get(independentCourse).add(dependentCourse);
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int poppedCourse = q.poll();
			if (adj.containsKey(poppedCourse)) {
				List<Integer> childs = adj.get(poppedCourse);
				for (Integer child : childs) {
					inDegree[child] = inDegree[child] - 1;
					if (inDegree[child] == 0) {
						q.offer(child);
					}
				}
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] != 0) {
				return false;
			}
		}
		return true;

	}

	// solution using topological sort using kahn's algorithm.
	public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		boolean[] visited = new boolean[numCourses];
		boolean[] recStk = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int independentCourse = prerequisites[i][1];
			int dependentCourse = prerequisites[i][0];
			if (!adj.containsKey(independentCourse)) {
				adj.put(independentCourse, new ArrayList<>());
			}
			adj.get(independentCourse).add(dependentCourse);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				if (dfsCycle(adj, i, visited, recStk)) {
					return false;
				}
			}
		}
		return true;

	}

	private static boolean dfsCycle(Map<Integer, List<Integer>> adj, int source, boolean[] visited, boolean[] recStk) {
		if (adj.containsKey(source)) {
			visited[source] = true;
			recStk[source] = true;
			List<Integer> childs = adj.get(source);
			for (Integer child : childs) {
				if (!visited[child]) {
					if (dfsCycle(adj, child, visited, recStk)) {
						return true;
					}
				} else if (recStk[child]) {
					return true;
				}
			}
			recStk[source] = false;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prerequisites = { { 0, 1 } };
		System.out.println("Can I take all courses: " + canFinish(2, prerequisites));
		System.out.println("Can I take all courses: " + canFinishDFS(2, prerequisites));
	}

}
