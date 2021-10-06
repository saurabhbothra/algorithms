package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

import com.algorithms.practice.tree.TreeNode;

public class SmallestSubtreeWithAllDeepestNodes {

	// Given the root of a binary tree, the depth of each node is the shortest
	// distance to the root.

	// Return the smallest subtree such that it contains all the deepest nodes in
	// the original tree.

	// A node is called the deepest if it has the largest depth possible among any
	// node in the entire tree.

	// The subtree of a node is a tree consisting of that node, plus the set of all
	// descendants of that node.
	
	public int maxDepth = -1;
    
	// dfs solution.
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        depthMap.put(null, -1);
        dfs(root, null, depthMap);
        for(Integer i: depthMap.values()) {
            maxDepth = Math.max(maxDepth, i);
        }
        return findNode(root, depthMap);
    }
    
    private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, Integer> depthMap) {
        if(root == null) {
            return;
        }
        depthMap.put(root, depthMap.get(parent) + 1);
        dfs(root.left, root, depthMap);
        dfs(root.right, root, depthMap);
    }
    
    private TreeNode findNode(TreeNode root, Map<TreeNode, Integer> depthMap) {
        if(root == null || depthMap.get(root) == maxDepth) {
            return root;
        } 
        TreeNode left = findNode(root.left, depthMap);
        TreeNode right = findNode(root.right, depthMap);
        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        return right;
    }
}
