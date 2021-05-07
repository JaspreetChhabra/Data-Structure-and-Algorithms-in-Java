package Stack.Easy;

//    Leetcode 496. Next Greater Element I https://leetcode.com/problems/next-greater-element-i/
//    You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
//
//    Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
//    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
//
//
//
//    Example 1:
//
//    Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//    Output: [-1,3,-1]
//    Explanation:
//    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//    For number 1 in the first array, the next greater number for it in the second array is 3.
//    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int number: nums2) {
            while(!stack.isEmpty() && stack.peek() < number)
                map.put(stack.pop(), number);
            stack.push(number);
        }

        for (int i=0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

    public static void main (String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
