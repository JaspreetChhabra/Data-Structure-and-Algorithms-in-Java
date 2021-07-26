package Algorithms.Backtracking.Medium;

//    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//    Example 1:
//
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//    Example 2:
//
//    Input: nums = [0,1]
//    Output: [[0,1],[1,0]]
//    Example 3:
//
//    Input: nums = [1]
//    Output: [[1]]

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> permutationList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums, 0);
        return permutationList;
    }

    private void permuteHelper(int[] nums, int startIndex){
        if (nums.length -1 == startIndex) {
            List<Integer> permutations = new ArrayList<>();
            for (int x: nums)
                permutations.add(x);

            permutationList.add(permutations);
        }

        for (int i=startIndex; i< nums.length; i++){
            swap(nums, startIndex, i);
            permuteHelper(nums, startIndex+1);
            swap(nums, i, startIndex);
        }
    }

    private void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args){
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{1,2,3}).forEach(permutation -> {
            System.out.println("");
            permutation.forEach(System.out::print);
        });
    }
}
