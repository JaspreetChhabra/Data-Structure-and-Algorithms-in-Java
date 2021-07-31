package Array.Medium;

//    Leetcode: 152. Maximum Product Subarray https://leetcode.com/problems/maximum-product-subarray/
//
//    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
//
//    It is guaranteed that the answer will fit in a 32-bit integer.
//
//    A subarray is a contiguous subsequence of the array.
//
//
//
//    Example 1:
//
//    Input: nums = [2,3,-2,4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.
//    Example 2:
//
//    Input: nums = [-2,0,-1]
//    Output: 0
//    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

public class MaximumProductSubarray {

    //Brute Force
    public static int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;

        int max = nums[0];
        int len = nums.length;

        for (int i=0; i < len; i++){
            int product = 1;
            for (int j =i; j < len; j++){
                product *= nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }

    //Optimised
    //https://leetcode.com/problems/maximum-product-subarray/discuss/183483/JavaC%2B%2BPython-it-can-be-more-simple
    public static int maxProduct1(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int left, right;
        left = right =0;

        for (int i=0; i < len; i++){
            left = (len ==0 ? 1 : left) * nums[i];
            right = (right ==0 ? 1 : right) * nums[i];
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }

    //DP
    public static int maxProductUsingDP(int[] nums) {
        int max_ending_here = nums[0];
        int min_so_far = nums[0];
        int len = nums.length;
        int result = max_ending_here;

        for (int i=1; i < len; i++){
            int curr = nums[i];

            int max_so_far = Math.max(curr, Math.max(max_ending_here*curr, min_so_far*curr));
            min_so_far = Math.min(curr, Math.min(max_ending_here*curr, min_so_far*curr));

            max_ending_here = max_so_far;

            result = Math.max(result, max_ending_here);
        }
        return result;
    }

    public static void main(String[] args){
        int arr[] = { 2, -5, 3, 1, -4, 0, -10, 2, 8 };

        System.out.println(maxProduct(arr));
        System.out.println(maxProduct1(arr));
        System.out.println(maxProductUsingDP(arr));
    }
}
