package Algorithms.Sorting;

import java.util.Arrays;

class QuickSort
{

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int start = low;
        int end = high;

        while (start < end){
            while (arr[start] <= pivot) start++;
            while (arr[end] > pivot) end--;

            if(start < end) swap(arr, start, end);
        }
        swap(arr, low, end);
        return end;
    }

    private void swap(int[] arr, int start , int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    void sort(int arr[], int low, int high)
    {
        if(low < high) {

            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex-1);
            sort(arr, pivotIndex+1, high);
        }
    }

    public static void main(String args[])
    {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
