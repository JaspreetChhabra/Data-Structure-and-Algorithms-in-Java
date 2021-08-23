package Array.Easy;

public class LargestSumContiguousSubarray {

    public static int getLargestSum(int[] array)
    {
        int max_sum, max_ending = 0;
        max_sum = Integer.MIN_VALUE;

        for (int i=0; i< array.length; i++){
            max_ending = max_ending + array[i];
            if(max_ending > max_sum){
                max_sum = max_ending;
            }
            if(max_ending < 0){
                max_ending =0;
            }
        }

        return max_sum;
    }

    public static void main(String[] args){
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max_sum = getLargestSum(a);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }
}
