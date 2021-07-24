package DynamicProgramming.CoinChange;

//    Longest Palindromic Substring | Set 1 https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
//    Difficulty Level : Hard
//    Last Updated : 09 Jun, 2021
//    Given a string, find the longest substring which is palindrome.
//
//    For example,
//
//    Input: Given string :"forgeeksskeegfor",
//    Output: "geeksskeeg"
//
//    Input: Given string :"Geeks",
//    Output: "ee"

public class LongestPalindromicSubString {
    public static int getLongestPalindromicSubstring(String str){

        int start =0, maxLength =1;
        int len = str.length();
        boolean[][] palin = new boolean[len][len];

        for(int i=0; i<len ; i++) palin[i][i] = true;
        for (int i=0; i<len-1 ; i++) {
            if(str.charAt(i) == str.charAt(i+1)){
                palin[i][i+1] = true;
                start=i;
                maxLength = 2;
            }
        }

        for (int end=3; end<=len ; end++){
            for (int startIndex=0; startIndex< len-end+1; ++startIndex){

                int endIndex = startIndex+end-1;
                if(str.charAt(startIndex) == str.charAt(endIndex) && palin[startIndex+1][endIndex-1] == true){
                    palin[startIndex][endIndex] = true;
                    start= startIndex;
                    maxLength=end;
                }
            }
        }

        if (maxLength > 1) printPalinSubstring(str, start, start + maxLength);
        return maxLength;
    }

    public static void printPalinSubstring(String str, int start, int len){
        System.out.println("Longest Palindromic String" + str.substring(start, len));
    }

    public static void main(String[] args){
        System.out.println("Longest Palindrome count "+ getLongestPalindromicSubstring("forgeeksskeegfor"));
    }
}
