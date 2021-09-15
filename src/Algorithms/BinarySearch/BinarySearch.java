package Algorithms.BinarySearch;

//    https://leetcode.com/problems/binary-search/
//    LeetCode 704. Binary Search
//
//    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//
//    You must write an algorithm with O(log n) runtime complexity.
//
//
//
//    Example 1:
//
//    Input: nums = [-1,0,3,5,9,12], target = 9
//    Output: 4
//    Explanation: 9 exists in nums and its index is 4

public class BinarySearch {

    public static int search(int[] nums, int target) {

        int high = nums.length  - 1;
        int low = 0;

        while (low <= high){

            int mid = low + ((high - low)/2);

            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) high = mid -1;
            else low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println("Index Number: " + search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
