package Strings.Medium;
//        Geeks - Coderita 2 https://practice.geeksforgeeks.org/contest/coderita-2021/problems/
//        Count the Substrings
//        Given a string S. The task is to count the number of substrings which contains equal number of lowercase and uppercase letters.
//
//        Example 1:
//
//        Input:
//        S = "gEEk"
//        Output: 3
//        Explanation: There are 3 substrings of
//        the given string which satisfy the
//        condition. They are "gE", "gEEk" and "Ek".

public class CountSubstring {

    public static void main(String[] args){
        String str = "gEEk";
        int big = 0;
        int small = 0;
        int substring = 0;
        for (int j = 0; j < str.length(); j++) {
            big = 0;
            small = 0;
            System.out.println(" ");
            for (int i = j; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                if (Character.isUpperCase(str.charAt(i))) {
                    big++;
                } else {
                    small++;
                }
                if (big == small) {
                    substring++;
                    break;
                }
            }
        }
        System.out.println("Count " + substring);

//        int ans=0;
//        for(int i=0;i<S.length();i++)
//        {
//            int c=0;
//            for(int j=i;j<S.length();j++)
//            {
//                if((int)S.charAt(j)>=(int)'a'&&(int)S.charAt(j)<=(int)'z')
//                    c++;
//                else
//                    c--;
//                if(c==0)
//                    ans++;
//            }
//        }
//        return ans;
    }
}
