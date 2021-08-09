package Heap;

public class HeapSort {

    public void sort(int[] arr){
        int n = arr.length;

        for (int i= n /2 -1; i>= 0; i--){
            heapify(arr, n, i);
        }

        for (int i= n-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int size, int pos){

        int largest = pos;
        int left = (pos * 2) +1;
        int right = ( pos * 2 ) +2;

        if(left < size && arr[largest] < arr[left]){
           largest = left;
        }

        if(right < size && arr[largest] < arr[right]){
            largest = right;
        }

        if( largest != pos){
            int temp = arr[largest];
            arr[largest] = arr[pos];
            arr[pos] = temp;

            heapify(arr, size, largest);
        }
    }

    private void print(int[] arr){
        for (int i=0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args){
        HeapSort heapSort = new HeapSort();

        int arr[] = { 12, 11, 13, 5, 6, 7 };
        heapSort.sort(arr);
        heapSort.print(arr);
    }
}
