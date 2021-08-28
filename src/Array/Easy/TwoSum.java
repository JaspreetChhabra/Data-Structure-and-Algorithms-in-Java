package Array.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//    LeetCode https://leetcode.com/problems/two-sum/
//    1. Two Sum
//
//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.
//
//    Example 1:
//
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complimentMap = new HashMap<>();

        for(int i=0; i< nums.length ; i++){
            int diff = target - nums[i];
            if(complimentMap.containsKey(diff)){
                return new int[] {complimentMap.get(diff), i};
            }
            complimentMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}
