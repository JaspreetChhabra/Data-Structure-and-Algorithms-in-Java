package Array.Easy;

//    Leetcode: 88. Merge Sorted Array https://leetcode.com/problems/merge-sorted-array/
//
//    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//    Example 1:
//
//    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    Output: [1,2,2,3,5,6]
//    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

import java.util.Arrays;

public class MergeTwoSortedArraysLC {

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1;
        int p2 = n-1;

        for(int p=m+n-1; p>=0; p--){
            if(p2<0) break;

            if(p1>=0 && nums1[p1] > nums2[p2]) nums1[p] = nums1[p1--];
            else nums1[p] = nums2[p2--];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        if(n == 0){
            return;
        }
        int j = 0;
        int shift = m-1;
        for ( int i=0; i < m+n ; i++) {

            if (nums1[i] >= nums2[j]){
                int k = shift;
                while ( k >= i){
                    nums1[k+1] = nums1[k];
                    k--;
                }

                nums1[i] = nums2[j];
                shift++;
                if(j == n-1)
                    break;
                else
                    j++;
            } else if ( i > shift) {
                nums1[i] = nums2[j];
                j++;
            }

        }
    }

    public static void main(String[] args){
       int[] nums1 = {1,2,3,0,0,0};
       int[] nums2 = {2,5,6};
       merge(nums1, 3, nums2, 3);
       System.out.println(Arrays.toString(nums1));
    }
}
