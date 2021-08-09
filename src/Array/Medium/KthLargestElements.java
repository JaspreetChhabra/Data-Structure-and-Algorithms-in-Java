package Array.Medium;

import java.util.Iterator;
import java.util.PriorityQueue;

//    Leet code: 215. Kth Largest Element in an Array https://leetcode.com/problems/kth-largest-element-in-an-array/
//    Geeks: https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
//
//    Given an integer array nums and an integer k, return the kth largest element in the array.
//
//    Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//    Example 1:
//
//    Input: nums = [3,2,1,5,6,4], k = 2
//    Output: 5
//    Example 2:
//
//    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4

public class KthLargestElements {

    private void sort(int[] arr, int k){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i=0; i<k; i++){
            priorityQueue.add(arr[i]);
        }

        for (int i=k; i< arr.length; i++){

            if(arr[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
            else continue;
        }

        Iterator iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(priorityQueue.poll());
        }
    }

    public static void main(String[] args) {
        KthLargestElements k = new KthLargestElements();
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };

        k.sort(arr, 3);

    }
}
