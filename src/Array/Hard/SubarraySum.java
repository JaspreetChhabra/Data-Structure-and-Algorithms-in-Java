package Array.Hard;

import java.util.Arrays;

//  Geeks - Coderita 2.0
//
//    Given an array A[ ] of N elements.
//    In one operation, you can select any subarray of length 2 and multiply all elements of that subarray by -1. You can do any number of operations (possibly zero).
//    Your task is to maximize the sum of all elements of all subarrays of A[ ].
//
//    Example 1:
//
//    Input:
//    N = 3
//    A[] = {-1, -2, -3}
//    Output: 14
//    Explanation:
//    We can do 1 operation on subarray from index = 2 to index = 3. After performing the operation, modified array A[] =
//    {-1, 2, 3}. All subarrays  of the  modified array A[] are [-1], [2], [3], [-1, 2], [2, 3]
//    and [-1, 2, 3]. Thus total sum of all subarrays is 14. This is the maximum sum
//    which we can get by performing the operations.

public class SubarraySum {

    //Method 1
    public static long SubArraySum(int arr[])
    {
        long result = 0,temp=0;

        // Pick starting point
        for (int i = 0; i < arr.length; i ++)
        {
            // Pick ending point
            temp=0;
            for (int j = i; j < arr.length; j ++)
            {
                // sum subarray between current
                // starting and ending points
                temp+=arr[j];
                result += temp ;
            }
        }
        return result ;
    }

    //Method 2
    long maxSum(int N, int A[])
    {
        long ans=0,ct=0;
        long mx=-1,ok=0;
        for(int i=0;i<N;i++)
        {
            long x=(long)(i+1)*(long)(N-i);
            x*=A[i];
            if(A[i]==0)
                ok=1;
            if(A[i]<0)
                ct++;
            if(mx==-1)
                mx=Math.abs(x);
            else
                mx=Math.min(mx,Math.abs(x));
            ans+=Math.abs(x);
        }
        if(ct%2==0||ok==1)
            return ans;
        return ans-2*mx;
    }

    public static void main(String[] args){
        int[] arr = {-1, -2, -3};

        Arrays.sort(arr);
        System.out.println("Sorted" + Arrays.toString(arr));
        for (int i=0; i < arr.length-1; i ++){
            int first = arr[i];
            int second = arr[i + 1];

            if (first < 0 && second < 0){
                    arr[i] = arr[i] * -1;
                    arr[i + 1] = arr[i + 1] * -1;
            } else if (first < 0) {
                first = first * -1;
                if( first > second){
                    arr[i] = arr[i] * -1;
                    arr[i + 1] = arr[i + 1] * -1;
                }
            }
        }

        System.out.println("Array" + Arrays.toString(arr));
        long result = SubArraySum(arr);
        System.out.println(result);
    }
}
