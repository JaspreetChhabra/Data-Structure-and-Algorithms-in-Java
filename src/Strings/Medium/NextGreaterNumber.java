package Strings.Medium;

import java.util.Arrays;

public class NextGreaterNumber {

    public static void findNext(char[] arr){
        int i;

        for (i =arr.length -1; i>=0; i-- ){
            if(arr[i] > arr[i-1]) break;
        }

        if(i == 0)
            System.out.println("Not Possible");
        else{

            int x = arr[i-1];
            int min = i;

            for (int j = i+1; j < arr.length; j++){
                if(arr[j] > x && arr[j] < arr[min]) min=j;
            }

            swap(arr, i, arr.length-1);

            Arrays.sort(arr, i-1, min);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < arr.length; i++)
                System.out.print(arr[i]);
        }
    }

    static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        char digits[] = { '5','3','4','9','7','6' };
        int n = digits.length;
        findNext(digits);
    }
}
