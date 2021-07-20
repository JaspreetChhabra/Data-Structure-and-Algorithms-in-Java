package Strings.Easy;
//    Geeks https://www.geeksforgeeks.org/number-substrings-string/
//    Find total number of non-empty substrings of a string with N characters.
//
//
//    Input : str = “abc”
//    Output : 6
//    Every substring of the given string : “a”, “b”, “c”, “ab”, “bc”, “abc”
//    Input : str = “abcd”
//    Output : 10
//    Every substring of the given string : “a”, “b”, “c”, “d”, “ab”, “bc”, “cd”, “abc”, “bcd” and “abcd”

public class SubStringCount {

    public static int getSubstringCount(String str) {
        int len = str.length();
        return len * (len + 1) / 2;
    }

    public static void main(String args[]) {
        String s = "abcde";
        System.out.println("Count of Substring: " + getSubstringCount(s));
    }
}
