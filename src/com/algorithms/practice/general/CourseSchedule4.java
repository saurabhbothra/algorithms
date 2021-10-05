package com.algorithms.practice.general;

import java.util.List;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CourseSchedule4 {

	// There are a total of numCourses courses you have to take, labeled from 0 to
	// numCourses - 1. You are given an array prerequisites where prerequisites[i] =
	// [ai, bi] indicates that you must take course ai first if you want to take
	// course bi.

	// For example, the pair [0, 1] indicates that you have to take course 0 before
	// you can take course 1.
	// Prerequisites can also be indirect. If course a is a prerequisite of course
	// b, and course b is a prerequisite of course c, then course a is a
	// prerequisite of course c.

	// You are also given an array queries where queries[j] = [uj, vj]. For the jth
	// query, you should answer whether course uj is a prerequisite of course vj or
	// not.

	// Return a boolean array answer, where answer[j] is the answer to the jth
	// query.

	// use bfs with topological sort.
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		int[] inDegree = new int[numCourses];
		Map<Integer, Set<Integer>> lookup = new HashMap<>();
		Map<Integer, List<Integer>> hmap = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int parent = prerequisites[i][0];
			int child = prerequisites[i][1];
			if (!hmap.containsKey(parent)) {
				hmap.put(parent, new ArrayList<>());
			}
			hmap.get(parent).add(child);
			inDegree[child] += 1;
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				lookup.put(i, new HashSet<>());
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int poppedNode = q.poll();
			if (hmap.containsKey(poppedNode)) {
				List<Integer> childs = hmap.get(poppedNode);
				if (childs.size() != 0) {
					for (Integer child : childs) {
						inDegree[child] -= 1;
						if (!lookup.containsKey(child)) {
							lookup.put(child, new HashSet<>());
						}
						lookup.get(child).add(poppedNode);
						Set<Integer> prereq = lookup.get(poppedNode);
						for (Integer pre : prereq) {
							lookup.get(child).add(pre);
						}
						if (inDegree[child] == 0) {
							q.offer(child);
						}
					}
				}
			}
		}

		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			if (lookup.get(queries[i][1]).contains(queries[i][0])) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

}
