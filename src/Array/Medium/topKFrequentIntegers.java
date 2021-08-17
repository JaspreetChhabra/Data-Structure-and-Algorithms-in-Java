package Array.Medium;

import Strings.Medium.TopKFrequentWords;

import java.util.*;

//    LeetCode https://leetcode.com/problems/top-k-frequent-elements/
//    347. Top K Frequent Elements
//
//    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//    Example 1:
//
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]
//    Example 2:
//
//    Input: nums = [1], k = 1
//    Output: [1]

public class topKFrequentIntegers {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return frequencyMap.get(o2) - frequencyMap.get(o1);
            }
        });

        maxHeap.addAll(frequencyMap.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(topKFrequent(new int[]{1,1,1,2,2,3}, 2)).forEach(System.out::println);
    }
}
