package Array.Easy;

public class TwoArraysAreEqual {

    public static boolean isEqual(int[] a, int[] b){
        int aLen = a.length;
        int bLen = b.length;

        if(aLen != bLen)
            return false;

        int aXOR = a[0];
        int bXOR = b[0];

        for (int i=1; i<aLen; i++){
            aXOR ^= a[i];
            bXOR ^= b[i];
        }

        int allXOR = aXOR ^ bXOR;
        return allXOR == 0;
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 5, 2, 5, 2 };
        int arr2[] = { 2, 3, 5, 5, 2 };

        // Function call
        if (isEqual(arr1, arr2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
