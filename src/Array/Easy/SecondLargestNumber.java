package Array.Easy;

public class SecondLargestNumber {

    static int getSecondLargestNumber(int[] unsortedArray) {

        int max1, max2;
        max1 = max2 = Integer.MIN_VALUE;

        if (unsortedArray.length < 2) {
            return -1;
        }

        for (int i = 0; i < unsortedArray.length; i++) {
            if (unsortedArray[i] > max1) {
                max2 = max1;
                max1 = unsortedArray[i];
            }
            if (unsortedArray[i] > max2 && unsortedArray[i] != max1) {
                max2 = unsortedArray[i];
            }
        }
        return max2;
    }

    public static void main(String[] args){
        int[] unsortedArray = {10,9,7,4,8,90};
        System.out.println("Second Largest element: " +getSecondLargestNumber(unsortedArray));
    }
}
