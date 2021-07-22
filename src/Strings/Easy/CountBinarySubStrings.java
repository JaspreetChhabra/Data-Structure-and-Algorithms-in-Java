package Strings.Easy;

//    LeetCode: 696. Count Binary Substrings https://leetcode.com/problems/count-binary-substrings/
//    Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//    Substrings that occur multiple times are counted the number of times they occur.
//
//
//
//    Example 1:
//
//    Input: s = "00110011"
//    Output: 6
//    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
//    Notice that some of these substrings repeat and are counted the number of times they occur.
//    Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//    Example 2:
//
//    Input: s = "10101"
//    Output: 4
//    Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.

public class CountBinarySubStrings {

    public static int countBinarySubstrings(String s) {
        int zero, one, count =0;
        int len = s.length();
        boolean flag;

        for (int i = 0; i < len; i++) {
            zero = 0;
            one = 0;
            char prev = s.charAt(i);
            flag = false;
            for (int j = i; j < len; j++) {
                if (zero == 0 && one == 0) {
                    prev = s.charAt(j);
                }
                if (s.charAt(j) == '0') zero++;
                else one++;

                if (prev != s.charAt(j) && !flag) {
                    flag = true;
                    prev = s.charAt(j);
                    if (zero == one) {
                        count++;
                        break;
                    }
                } else {
                    if (zero == one) {
                        count++;
                        break;
                    }
                }

                if (prev != s.charAt(j) && flag) {
                    break;
                }
            }
        }
        return count;
    }

    public static int countBinarySubstrings1(String s) {
        int[] group = new int[s.length()];

        int t=0;
        group[0] = 1;
        for (int i=1; i < s.length(); i++){
            if( s.charAt(i-1) != s.charAt(i)) {
                group[++t] = 1;
            }
            else {
                group[t]++;
            }
        }

        int count=0;
        for (int i=1; i <= t; i++){
            count += Math.min(group[i-1], group[i]);
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(countBinarySubstrings("101111100")); //4
        System.out.println(countBinarySubstrings("00110011")); //6
        System.out.println(countBinarySubstrings1("11001111101101100111111111111100110010111111111001101111111111010100100111100011111101111011111101011101000011110011100111010110001110111010111111101011001011111101011011011111110011111110000111101101011111111110101010011111000100000010011010011001011111101101111101111110100110011101111011100010111001100110100010111000000011010000111001111110101101011101100000111101101111010101100101011111010111111111111101001101011111011110011010111011111111111001110110110100101101111111011100110111111111100011101100001011111111111011100111110111000101111100111101111111101110001101010111011010111010110111000111011011111101110001111101011001101111110011111101111111011011100111011101111101111111010011111001110101110111100110111001011001010101100010111001101111011111101111111111100101011001001111101010111110101011011011111101111110110110010011110011110001110101111001001100111111111001001111000111110111000010011011110110111100101011100011110100000011111100010110001101101111110001100011101011001111111000")); //584
        System.out.println(countBinarySubstrings1("1101001000101110000000001001001111011111000111101101100000110001110101000011001101111100")); //53
        System.out.println(countBinarySubstrings("110110011000")); //8
        System.out.println(countBinarySubstrings("10110011000")); //8


    }
}
