package Array.Medium;

public class MaximumSubarraySumWithOneDeletion {

    public static int getMaximumSubarraySum(int[] arr){

        int max_sum_so_far = 0;
        boolean isAllPositive = true;
        int len = arr.length;

        for (int i=0; i< len; i++){
            if (arr[i] < 0) isAllPositive=false;
            max_sum_so_far += arr[i];
        }
        if(isAllPositive) return max_sum_so_far;

        int[] fwd_sum_arr = new int[len];
        int curr_sum = fwd_sum_arr[0] = max_sum_so_far = arr[0];

        for(int i =1; i< len; i++){
            curr_sum = Math.max(arr[i], curr_sum+arr[i]);
            max_sum_so_far = Math.max(max_sum_so_far, curr_sum);

            fwd_sum_arr[i] = curr_sum;
        }

        int[] back_sum_arr = new int[len];
        curr_sum = back_sum_arr[len-1] = max_sum_so_far = arr[len-1];

        for(int i = len-2; i>= 0; i--){
            curr_sum = Math.max(arr[i], curr_sum+arr[i]);
            max_sum_so_far = Math.max(max_sum_so_far, curr_sum);
            back_sum_arr[i] = curr_sum;
        }

        for (int i=1; i< len-1; i++ ){
            max_sum_so_far = Math.max(max_sum_so_far, fwd_sum_arr[i-1] + back_sum_arr[i+1]);
        }

        return max_sum_so_far;
    }

    // Driver code
    public static void main(String arg[])
    {
        int arr[] = { -1,-1,-1,-1 };
        System.out.println(getMaximumSubarraySum(arr));

        int arr1[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(getMaximumSubarraySum(arr1));
    }
}
