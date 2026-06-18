package com.algorithms.practice.bitmagic;

/*
LC: 78: Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        int subsets = (int) Math.pow(2, nums.length);
        for(int i = 1; i < subsets; i++) {
            List<Integer> positions = getSetBitPositions(i);
            List<Integer> solution = new ArrayList<>();
            for(int j = 0; j < positions.size(); j++) {
                solution.add(nums[positions.get(j)]);
            }
            output.add(solution);
        }
        return output;
    }

    private static List<Integer> getSetBitPositions(int n) {
        List<Integer> output = new ArrayList<>();
        int pos = 0;
        while(n > 0) {
            if ((n & 1) != 0) {
                output.add(pos);
            }
            pos = pos + 1;
            n = n >> 1;
        }
        return output;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = { 1, 2, 3 };
        System.out.println("The subsets are:");
        List<List<Integer>> output = subsets(nums);
        System.out.println();
        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }
}
