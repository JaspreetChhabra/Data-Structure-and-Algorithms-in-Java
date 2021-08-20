package Array.Medium;

import java.util.Arrays;

//    Leetcode https://leetcode.com/problems/largest-number/
//    179. Largest Number
//
//    Given a list of non-negative integers nums, arrange them such that they form the largest number.
//
//    Note: The result may be very large, so you need to return a string instead of an integer.
//
//    Example 1:
//
//    Input: nums = [10,2]
//    Output: "210"
//    Example 2:
//
//    Input: nums = [3,30,34,5,9]
//    Output: "9534330"

public class FormLargestNumber {

    public static String getLargestNumber(int[] arr){
        String[] stringArr = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(stringArr, (String s1,String s2) -> (s2+s1).compareTo(s1+s2));
        return Arrays.stream(stringArr).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }

    public static void main(String[] args){
        System.out.println(getLargestNumber(new int[]{3,30,34,5,9}));
    }
}
