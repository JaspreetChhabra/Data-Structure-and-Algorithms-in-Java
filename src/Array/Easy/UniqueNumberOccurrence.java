package Array.Easy;

//    LeetCode: 1207. Unique Number of Occurrences https://leetcode.com/problems/unique-number-of-occurrences/
//
//    Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
//
//
//
//    Example 1:
//    
//    Input: arr = [1,2,2,1,1,3]
//    Output: true
//    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOccurrence {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurMap = new HashMap<>();

        for(int number: arr) {
            occurMap.put(number, 1 + occurMap.getOrDefault(number, 0));
        }

        return occurMap.size() == new HashSet<>(occurMap.values()).size();

//        Iterator iterator = occurMap.entrySet().iterator();
//
//        while(iterator.hasNext()){
//            Map.Entry entry = (Map.Entry)iterator.next();
//            int key = (int) entry.getKey();
//            int value = (int) entry.getValue();
//            occurMap.put(key, 0);
//            if(occurMap.containsValue(value)) {
//                return false;
//            }
//        }
    }

    public static void main(String[] args) {
        int[] uniqueOccurenceArray = {-3,0,1,-3,1,1,1,-3,10,0};

        System.out.println("Unique Occurrence "+ uniqueOccurrences(uniqueOccurenceArray));

        int[] NonUniqueOccurenceArray = {1,2};

        System.out.println("Unique Occurrence "+ uniqueOccurrences(NonUniqueOccurenceArray));
    }
}
