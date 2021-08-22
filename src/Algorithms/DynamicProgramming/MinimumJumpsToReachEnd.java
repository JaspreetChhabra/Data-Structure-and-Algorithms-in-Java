package Algorithms.DynamicProgramming;

public class MinimumJumpsToReachEnd {

    public static int minimumJumps(int[] arr){

        int[] min_jumps = new int[arr.length];

        for (int i=1; i < arr.length; i++){
            min_jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++){
                if(j + arr[j] >= i && min_jumps[j] != Integer.MAX_VALUE){
                    min_jumps[i] = Math.min(min_jumps[i], min_jumps[j]+1);
                }
            }
        }
        return min_jumps[arr.length -1];
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 3, 6, 1, 0, 9 };

        System.out.println("Minimum number of jumps to reach end is : "
                + minimumJumps(arr));
    }
}
