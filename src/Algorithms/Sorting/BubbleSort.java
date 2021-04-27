package Algorithms.Sorting;

public class BubbleSort {

    void sort(int[] unsortedArr) {

        int n = unsortedArr.length;

        for (int i = 0; i< n-1; i++){
            for (int j = 0; j < n-i-1; j++) {
                if(unsortedArr[j] > unsortedArr[j+1]) {
                    int temp = unsortedArr[j+1];
                    unsortedArr[j+1] = unsortedArr[j];
                    unsortedArr[j] = temp;
                }
            }
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

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        bubbleSort.printArray(arr);
    }
}
