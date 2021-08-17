package Array.Easy;

public class MissingNumberFromShuffledArray {

    public static int getMissingElement(int[] a, int[] b){

        int asum = a[0];
        for (int j=1; j<a.length; j++){
            asum ^= a[j];
        }

        int bsum = b[0];
        for (int j=1; j<b.length; j++){
            bsum ^= b[j];
        }

        return asum ^ bsum;
    }

    public static void main (String[] args)
    {
        int arr1[] = {4, 8, 1, 3, 7};
        int arr2[] = { 4, 3, 1, 8};

        System.out.println("Missing number = "
                + getMissingElement(arr1, arr2));
    }
}
