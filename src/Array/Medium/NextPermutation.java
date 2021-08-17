package Array.Medium;

import java.util.Arrays;

//        Leetcode : https://leetcode.com/problems/next-permutation/
//        31. Next Permutation
//
//        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
//        The replacement must be in place and use only constant extra memory.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [1,3,2]

public class NextPermutation {

    public static void nextPermutation(int[ ] a){
        if(a == null || a.length <= 1) return;

        int i = a.length -2;

        while (i >=0 && a[i] >= a[i+1]) i--;

        if(i >= 0){
            int j = a.length - 1;
            while (a[j] <= a[i]) j--;
            swap(a, i , j);
        }
        reverse(a, i+1, a.length-1);
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void reverse(int[] a, int start, int end){
        while (start < end) swap(a, start++, end--);
    }

    public static void main(String[] args){
        int[] arr = {1,1,5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

    }
}
