package Sorting;

public class InsertionSort {

    void sort(int[] unsortedArr) {
        int len = unsortedArr.length;

        for (int i = 1; i < len; ++i) {

            int key = unsortedArr[i];
            int j = i-1;

            while (j >= 0 && unsortedArr[j] > key) {
                unsortedArr[j + 1] = unsortedArr[j];
                j = j-1;
            }

            unsortedArr[j+1] = key;
        }
    }

    void recursiveSort(int[] unsortedArr, int n){
        if (n == 0)
            return;

        int key = unsortedArr[n];
        int j = n-1;

        while (j >= 0 && unsortedArr[j] > key) {
            unsortedArr[j + 1] = unsortedArr[j];
            j = j-1;
        }

        unsortedArr[j+1] = key;

        recursiveSort(unsortedArr, n-1);

    }
    void printArray(int[] arr) {
        for (int i =0; i < arr.length ; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,6,2,2,0};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.recursiveSort(arr, arr.length-1);
        insertionSort.printArray(arr);
    }
}
