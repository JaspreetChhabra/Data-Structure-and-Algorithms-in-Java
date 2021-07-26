package Algorithms.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

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

public class PalindromePartitioningUsingDP {
    List<List<String>> partitionsList = new ArrayList<>();
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        partitionHelper(s, 0, new ArrayList<>(), dp);
        return partitionsList;
    }

    public void partitionHelper(String str, int start, List<String> partitions, boolean[][] dp){
        if(str.length() == start) partitionsList.add(new ArrayList<>(partitions));

        for (int end= start; end< str.length(); end++){
            String temp = str.substring(start, end+1);
            if(str.charAt(start) == str.charAt(end) && (end - start <= 2 || dp[start+1][end-1])){
                dp[start][end] = true;
                partitions.add(temp);
                partitionHelper(str, end+1, partitions, dp);
                partitions.remove(partitions.size()-1);
            }
        }

    }

    public static void main(String[] args){
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("aab").forEach(partition -> {
            partition.forEach(System.out::println);
        });
    }
}
