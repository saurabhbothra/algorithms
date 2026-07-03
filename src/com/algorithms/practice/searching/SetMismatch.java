package com.algorithms.practice.searching;

/*
LC: 645: You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.



Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]


Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
 */

public class SetMismatch {

    // efficient solution with space
    public static int[] findErrorNums(int[] nums) {
        int[] output = new int[2];
        int[] temp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            temp[nums[i]] = temp[nums[i]] + 1;
        }
        for(int i = 0; i < temp.length; i++) {
            if (temp[i] > 1) {
                output[0] = i;
            }
            if (temp[i] == 0) {
                output[1] = i;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = { 1, 2, 2, 4 };
        int[] output = findErrorNums(nums);
        System.out.println("The error nums are: " + output[0] + ", " + output[1]);
    }
}
