package Array.Easy;

import java.time.Year;
import java.util.Arrays;

public class MergeTwoSortedArraysGFG {

    public static void mergeUsingInsertionSort(int[] nums1, int[] nums2){

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

    public static int nextgap(int gap){
        if(gap <=1 ) return 0;

        return (gap/2) + (gap%2);
    }

    public static void merge(int[] nums1, int[] nums2){

        int n = nums1.length;
        int m = nums2.length;

        int i,j, gap = n+m;

        for(gap = nextgap(gap); gap>0; gap=nextgap(gap)){
            for(i = 0; i+gap < n ;i++){
                if(nums1[i] > nums1[i+gap]){
                    int temp = nums1[i];
                    nums1[i] = nums1[i+gap];
                    nums1[i+gap] = temp;
                }
            }

            for (j = gap > n ? gap-n : 0; i < n && j <m ;i++, j++){
                if (nums1[i] > nums2[j]){
                    int temp = nums1[i];
                    nums1[i] = nums2[j];
                    nums2[j] = temp;
                }
            }

            if(j<m){
                for(j = 0; j+gap < n ;j++){
                    if(nums2[j] > nums2[j+gap]){
                        int temp = nums2[j];
                        nums2[j] = nums2[j+gap];
                        nums2[j+gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,7};
        int[] nums2 = {4,5,6};
        merge(nums1, nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
