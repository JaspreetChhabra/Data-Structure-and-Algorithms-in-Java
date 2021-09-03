package Algorithms.Recursion;

// Geeks https://practice.geeksforgeeks.org/problems/subset-sums2234/1

//    Given a list arr of N integers, print sums of all subsets in it.
//
//    Example 1:
//
//    Input:
//    N = 2
//    arr[] = {2, 3}
//    Output:
//    0 2 3 5
//    Explanation:
//    When no elements is taken then Sum = 0.
//    When only 2 is taken then Sum = 2.
//    When only 3 is taken then Sum = 3.
//    When element 2 and 3 are taken then
//            Sum = 2+3 = 5.

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {

    private static void getSubsetSum(ArrayList<Integer> sumSubsets, int ind, int[] arr, int N, int sum){

        if(ind == N){
            sumSubsets.add(sum);
            return;
        }

        getSubsetSum(sumSubsets, ind + 1, arr, N, sum + arr[ind]);
        getSubsetSum(sumSubsets, ind+1, arr, N, sum);
    }
    private static ArrayList<Integer> subSetSum(int[] arr, int N){

        ArrayList<Integer> sumSubsets = new ArrayList<>();
        getSubsetSum(sumSubsets, 0, arr, N, 0);
        Collections.sort(sumSubsets);
        return sumSubsets;
    }
    public static void main(String[] args){
        subSetSum(new int[]{2, 3}, 2).forEach(System.out::println);
    }

}
