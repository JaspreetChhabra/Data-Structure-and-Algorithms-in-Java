package Array.Easy;

import java.util.Arrays;

//    Leetcode: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
//    1385. Find the Distance Value Between Two Arrays
//
//    Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
//
//    The distance value is defined as the number of elements arr1[i] such that there is not any element
//            arr2[j] where |arr1[i]-arr2[j]| <= d.


public class DistanceBetweenTwoArrays {

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int ans =0;
        for (int a: arr1){
            if(Arrays.binarySearch(arr2, a-d) == Arrays.binarySearch(arr2, a+d)){
                ans++;
            }
        }
        return ans;
    }

    public static int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int ans =0;
        for (int a: arr1){
            if(existsInRange(arr2, a-d, a+d)){
                ans++;
            }
        }
        return ans;
    }

    private static boolean existsInRange(int[] arr, int from, int to) {
        int low = 0;
        int high = arr.length -1;

        while (low <= high){
            int mid = (low+high)/2;

            if(arr[mid] >= from && arr[mid] <= to) return false;
            else if(arr[mid] < from) low = mid+1;
            else high = mid-1;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2));
        System.out.println(findTheDistanceValue(new int[]{1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3));
        System.out.println(findTheDistanceValue1(new int[]{2,1,100,3}, new int[]{-5,-2,10,-3,7}, 6));
    }
}
