package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int getIncreasingSubsequence(int[] arr, int n){

        int[] dp = new int[n];
        int len =1;

        dp[0] = arr[0];

        for (int i =1; i< n; i++){

            if(arr[i] < dp[0])
                dp[0] = arr[i];
            else if(arr[i] > dp[len-1])
                dp[len++] = arr[i];
            else
                dp[binarySearch(dp, -1, len-1, arr[i])] = arr[i];
        }
        return len;
    }

    private static int binarySearch(int[] arr, int start, int end, int key){
        while (end - start > 1){
            int mid = start + (end- start)/2;

            if(arr[mid] >= key)
                end = mid;
            else
                start = mid;
        }
        return end;
    }

    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is " + getIncreasingSubsequence(A, n));
    }
}
