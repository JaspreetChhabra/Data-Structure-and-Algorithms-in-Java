package Algorithms.Backtracking.Medium;

//    LeetCode: 131. Palindrome Partitioning https://leetcode.com/problems/palindrome-partitioning/
//    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
//    A palindrome string is a string that reads the same backward as forward
//    Example 1:
//
//    Input: s = "aab"
//    Output: [["a","a","b"],["aa","b"]]
//    Example 2:
//
//    Input: s = "a"
//    Output: [["a"]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> partitionsList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partitionHelper(s, 0, new ArrayList<>());
        return partitionsList;
    }

    public void partitionHelper(String str, int start, List<String> partitions){
        if(str.length() == start) partitionsList.add(new ArrayList<>(partitions));

        for (int end= start; end< str.length(); end++){
            String temp = str.substring(start, end+1);
            if(isPalindrome(temp)){
                partitions.add(temp);
                partitionHelper(str, end+1, partitions);
                partitions.remove(partitions.size()-1);
            }
        }

    }

    private boolean isPalindrome(String str){
        int i =0, j=str.length()-1;

        while (i<=j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("aab").forEach(partition -> {
            partition.forEach(System.out::println);
        });
    }

}
