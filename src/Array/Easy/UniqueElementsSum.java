package Array.Easy;

//  LeetCode 1748. Sum of Unique Elements
//  You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
//
//  Return the sum of all the unique elements of nums.
//
//
//
//  Example 1:
//
//  Input: nums = [1,2,3,2]
//  Output: 4
//  Explanation: The unique elements are [1,3], and the sum is 4

import java.util.HashMap;

public class UniqueElementsSum {

    public static int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number: nums){
            map.put(number, 1 + map.getOrDefault(number, 0));
        }

        // int sum = map.keySet().stream().reduce(0, Integer::sum);
        return map.entrySet().stream().filter(o -> o.getValue() == 1).mapToInt(o -> o.getKey()).sum();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};

        System.out.println("Unique Elements Sum " + sumOfUnique(nums));
    }
}
