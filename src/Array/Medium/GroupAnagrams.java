package Array.Medium;

import java.util.*;
//Geeks https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
// https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/

//  LeetCode 49 : https://leetcode.com/problems/group-anagrams/
//  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//  Example 1:
//
//  Input: strs = ["eat","tea","tan","ate","nat","bat"]
//  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {

            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String str1 = new String(arr);

            if(map.containsKey(str1)) {
                List<String> list = map.get(str1);
                list.add(str);
                map.put(str1, list);
            }
            else {
                List<String> strlt = new ArrayList<>();
                strlt.add(str);
                map.put(str1, strlt);
            }
        }

        map.forEach((k,v) -> group.add(v));
        return group;
    }

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> groupedAnagrams = groupAnagrams(strs);
        System.out.println(groupedAnagrams);
        //output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}
