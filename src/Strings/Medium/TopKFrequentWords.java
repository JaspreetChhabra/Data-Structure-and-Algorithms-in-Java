package Strings.Medium;

import java.util.*;

//    LeetCode: https://leetcode.com/problems/top-k-frequent-words/
//    692. Top K Frequent Words
//
//    Given an array of strings words and an integer k, return the k most frequent strings.
//
//    Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
//
//    Example 1:
//
//    Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//    Output: ["i","love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.


public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Pair> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (frequencyMap.containsKey(word.toLowerCase()))
                frequencyMap.put(word, frequencyMap.get(word).inc());
            else
                frequencyMap.put(word, new Pair(word, 1));
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (frequencyMap.get(o1.string).frequency == frequencyMap.get(o2.string).frequency)
                    return o1.string.compareTo(o2.string);
                else
                    return o2.frequency - o1.frequency;
            }
        });

        maxHeap.addAll(frequencyMap.values());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Pair pair = maxHeap.poll();
            result.add(pair.string);
        }

        return result;

    }

    class Pair {
        String string;
        int frequency;

        public Pair(String string, int frequency) {
            this.string = string;
            this.frequency = frequency;
        }

        public Pair inc() {
            this.frequency++;
            return this;
        }
    }

    public List<String> topKFrequent1(String[] words, int k) {

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (frequencyMap.get(o1) == frequencyMap.get(o2))
                    return o1.compareTo(o2);
                else
                    return frequencyMap.get(o2) - frequencyMap.get(o1);
            }
        });

        maxHeap.addAll(frequencyMap.keySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }

        return result;

    }

    public static void main(String[] args) {
        TopKFrequentWords expedia = new TopKFrequentWords();
        //expedia.topKFrequent(new String[]{"Today", "is", "is", "a", "a", "a", "good", "good", "good", "day", "day", "day"}, 4).forEach(System.out::println);
        expedia.topKFrequent1(new String[]{"Today", "is", "is", "a", "a", "a", "good", "good", "good", "day", "day", "day"}, 4).forEach(System.out::println);

    }
}
