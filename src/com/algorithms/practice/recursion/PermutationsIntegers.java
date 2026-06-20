package com.algorithms.practice.recursion;

/*
LC: 46: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIntegers {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> mutableList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        permutations(mutableList, output, 0);
        return output;
    }

    private static void permutations(List<Integer> nums, List<List<Integer>> output, int level) {
        if (level == nums.size()) {
            output.add(nums);
            return;
        }
        for(int i = level; i < nums.size(); i++) {
            List<Integer> copy = new ArrayList<>(nums);
            int temp = copy.get(level);
            copy.set(level, copy.get(i));
            copy.set(i, temp);
            permutations(copy, output, level + 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println("The permutations are:");
        List<List<Integer>> output = permute(nums);
        System.out.println();
        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }
}
