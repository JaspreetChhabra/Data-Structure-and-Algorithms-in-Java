package Algorithms.DynamicProgramming.CoinChange;

public class CoinChangeUsing2DArray {
    public static int coinChangeUsing2D(int amount, int[] coins) {
        int[][] table = new int[coins.length][amount+1];

        for (int i=0; i < coins.length; i++){
            table[i][0] = 1;
        }

        for (int i=0; i <= amount; i++){
            table[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for( int i =1; i< coins.length; i++){
            for (int j=1; j<= amount; j++){
                if (coins[i] > j) {
                    table[i][j] = table[i-1][j];
                }else {
                    table[i][j] = table[i-1][j] + table[i][j-coins[i]];
                }
            }
        }

        return table[coins.length-1][amount];
    }

    public static void main(String[] args){
        int[] arr = {1,2,5};
        System.out.println(coinChangeUsing2D(5, arr));
    }
}
