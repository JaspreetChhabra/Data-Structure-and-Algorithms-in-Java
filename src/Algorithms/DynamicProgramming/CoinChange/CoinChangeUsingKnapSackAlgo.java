package Algorithms.DynamicProgramming.CoinChange;

public class CoinChangeUsingKnapSackAlgo {

    // https://www.youtube.com/watch?v=Htajsa6TB7U&list=PLgUwDviBIf0pmD4Eur6Cl5XfBO4EtgKGe&index=6
    public static int coinChange(int[] coins, int[][] dp, int sum, int ind){
        if(sum < 0 || ind >= coins.length) return 0;

        if(sum == 0) return 1;

        if(dp[ind][sum] == -1){
            return dp[ind][sum] = coinChange( coins, dp, sum - coins[ind], ind) + coinChange(coins, dp, sum, ind+1);
        }
        else
            return dp[ind][sum];
    }
    public static void main(String[] args){
        int[] arr = {1,2,5};
        int amount = 5;

        int[][] dp = new int[arr.length][amount+1];
        for (int i=0; i < arr.length; i++){
            for (int j=0; j<= amount; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(coinChange(arr, dp, amount, 0));
    }

}
