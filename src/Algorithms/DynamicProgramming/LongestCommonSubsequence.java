package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int getLCS(String s1, String s2, int i, int j, int[][]dp){

        if(i > s1.length() || j > s2.length())
            return 0;

        if(dp[i][j] == -1){
            if(s1.charAt(i) == s2.charAt(j))
                return dp[i][j] = 1+ getLCS(s1, s2, i+1, j+1, dp);
            else {
                return dp[i][j] = Math.max(getLCS(s1, s2, i+1, j, dp) , getLCS(s1, s2, i, j+1, dp));
            }
        }
        else return dp[i][j];
    }

    public static void main(String[] args){
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i=0; i < n; i++){
            for (int j=0; j< m; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println("Length of longest common subsequence: " + getLCS(s1, s2, 0, 0, dp));
    }
}
