package Sorting;

// Java program for implementation of QuickSort
class QuickSort
{
    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; //80
        int i = (low-1); // index of smaller element //4
        for (int j=low; j<high; j++) //6
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) //80 < 80
            {
                i++; //3

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } // 10 30 40 50 70 90 80
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1]; //90
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    } // 10 30 40 50 70 80 90


    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    void sort(int arr[], int low, int high)
    {
        System.out.println("1: " + low + " " + high );
        if (low < high)
        {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            System.out.println("2: " + low + " " + high + " " + pi);
            sort(arr, low, pi-1);
            System.out.println("3: " + low + " " + high + " " + pi);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}
/*This code is contributed by Gaurav Majmudar */

