package Array.Medium;

import java.util.*;
//Geeks https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

//  LeetCode 75 : https://leetcode.com/problems/sort-colors/
//    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//    Example 1:
//
//    Input: nums = [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//    Example 2:
//
//    Input: nums = [2,0,1]
//    Output: [0,1,2]

public class SortColors {
    public static void sortColor(int[] num){
        int low, mid, high;
        low = mid = 0;
        high = num.length -1;
        int temp =0;

        while (mid <= high){
            if(num[mid] == 0){
                temp = num[low];
                num[low] = num[mid];
                num[mid] = temp;
                low++;
                mid++;
            }
            else if(num[mid] == 1){
                mid++;
            }
            else {
                temp = num[high];
                num[high] = num[mid];
                num[mid] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args){
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }
}
