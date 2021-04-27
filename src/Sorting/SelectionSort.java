package Sorting;

import java.util.Arrays;

public class SelectionSort {
    
    void selectionSort(int[] unsortedArr) {

        int length = unsortedArr.length;

        for (int i =0 ; i<length ; i++) {
            int min_idx = i;

            for (int j = i+1; j < length; j++ ) {
                if (unsortedArr[j] < unsortedArr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = unsortedArr[i];
            unsortedArr[i] = unsortedArr[min_idx];
            unsortedArr[min_idx] = temp;
        }
    }

    void printArray(int[] arr) {
        for (int i =0; i < arr.length ; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,6,2,2};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(arr);
        selectionSort.printArray(arr);

    }
}
