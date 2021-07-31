package Array.Easy;

import java.time.Year;
import java.util.Arrays;

public class MergeTwoSortedArraysGFG {

    public static void merge(int[] nums1, int[] nums2){

        for (int m=0; m< nums1.length; m++){

            if(nums1[m] > nums2[0]){
                int temp = nums1[m];
                nums1[m] = nums2[0];
                nums2[0] = temp;

                int first = nums2[0];
                int k;
                for (k =1; k< nums2.length && nums2[k] < first; k++ ){
                    nums2[k-1] = nums2[k];
                }
                nums2[k - 1] = first;
            }
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,7};
        int[] nums2 = {2,5,6};
        merge(nums1, nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
