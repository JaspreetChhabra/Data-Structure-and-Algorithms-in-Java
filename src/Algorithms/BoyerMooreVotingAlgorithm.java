package Algorithms;

//    https://leetcode.com/problems/majority-element/solution/
//    LeetCode 169. Given an array nums of size n, return the majority element.
//
//    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//    Example 1:
//
//    Input: nums = [3,2,3]
//    Output: 3
//    Example 2:
//
//    Input: nums = [2,2,1,1,1,2,2]
//    Output: 2


public class BoyerMooreVotingAlgorithm {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;

        for(int number: nums){
            if(count == 0) num = number;

            count += (number == num) ? 1 : -1;
        }

        return num;
    }

    public static void main(String[] args){
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
