package Strings.Easy;

// LeetCode 242. Valid Anagram https://leetcode.com/problems/valid-anagram/solution/
// https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

// Check whether two strings are anagram of each other
//
// Write a function to check whether two given strings are anagram of each other or not.
// An anagram of a string is another string that contains the same characters, only the order of characters can be different.
// For example, “abcd” and “dabc” are an anagram of each other.
//
//    Input: s = "anagram", t = "nagaram"
//    Output: true

import java.util.Arrays;

public class StringAnagrams {

    // O(nlogn)
    public static boolean compareStrings(char[] str1, char[] str2){
        int len1 = str1.length;
        int len2 = str2.length;

        if(len1 != len2){
            return false;
        }

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i=0; i<len1 ; i++){
            if(str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean stringAnagram(char[] str1, char[] str2){

        final int MAX_CHAR = 256;

        int[] count = new int[MAX_CHAR];

        if(str1.length != str2.length)
            return false;

        for (int i=0; i< str1.length; i++){
            count[str1[i] - 'a']++;
            count[str2[i] - 'a']--;
        }

        for (int i=0; i<MAX_CHAR; i++){{
            if (count[i] != 0) return false;
        }}

        return true;
    }

    public static void main(String[] args){
        char str1[] = { 't', 'e', 's', 't' };
        char str2[] = { 't', 't', 'e', 's' };

        System.out.println("Strings are anagram: " + compareStrings(str1, str2));

        char str3[] = { 't', 'e', 's', 't' };
        char str4[] = { 't', 't', 'e', 'w' };

        System.out.println("Strings are anagram: " + stringAnagram(str3, str4));
    }
}
