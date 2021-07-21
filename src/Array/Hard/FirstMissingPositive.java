package Array.Hard;

//    LeetCode: 41. First Missing Positive https://leetcode.com/problems/first-missing-positive/
//    https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
//    Given an unsorted integer array nums, find the smallest missing positive integer.
//
//    You must implement an algorithm that runs in O(n) time and uses constant extra space.
//
//
//
//    Example 1:
//
//    Input: nums = [1,2,0]
//    Output: 3
//    Example 2:
//
//    Input: nums = [3,4,-1,1]
//    Output: 2
//    Example 3:
//
//    Input: nums = [7,8,9,11,12]
//    Output: 1

public class FirstMissingPositive {

    public static int findFirstMissingPositiveNumber(int[] arr){
        int i=0, len = arr.length;

        while (i < len){
            if(arr[i] >= 0 && arr[i] < len && arr[arr[i]] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }else i++;
        }

        i=1;
        while ( i< len && arr[i] == i) i++;

        if ( len == 0 || i < len){
            return i;
        } else return arr[i] == 0 ? i+1 : i;
    }

    public static void main(String[] args){
        int[] nums = {3,4,-1,1};
        System.out.println("First Missing Positive Number: " + findFirstMissingPositiveNumber(nums));
    }
}
