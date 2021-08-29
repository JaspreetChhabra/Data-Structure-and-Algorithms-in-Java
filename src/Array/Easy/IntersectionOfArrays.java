package Array.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//    LeetCode: https://leetcode.com/problems/intersection-of-two-arrays-ii/
//    350. Intersection of Two Arrays II
//
//    Given two integer arrays nums1 and nums2, return an array of their intersection.
//    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//    Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]
//    Explanation: [9,4] is also accepted.

public class IntersectionOfArrays {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return intersect(nums2, nums1);

        Map<Integer, Integer> frequencyArray = new HashMap<>();

        for(int i=0; i< nums1.length; i++){
            frequencyArray.put(nums1[i], frequencyArray.getOrDefault(nums1[i], 0) + 1);
        }

        int i =0;
        for(int n: nums2){
            int count = frequencyArray.getOrDefault(n, 0);

            if(count > 0){
                nums1[i++] = n;
                frequencyArray.put(n, count- 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, i);
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i, j, k;
        i = j= k =0;

        while(i < nums1.length && j < nums2.length){

            if( nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else{
                nums1[k++] =nums1[i++];
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0 , k);
    }

    public static void main(String[] args){

        System.out.println(Arrays.toString(intersect(new int[] {1,2,2,1} , new int[] {2,2})));
        System.out.println(Arrays.toString(intersect1(new int[] {4,9,5} , new int[] {9,4,9,8,4})));
    }
}
