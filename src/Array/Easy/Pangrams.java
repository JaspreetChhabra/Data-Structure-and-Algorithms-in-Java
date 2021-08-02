package Array.Easy;

//    Leetcode: 1832. Check if the Sentence Is Pangram https://leetcode.com/problems/check-if-the-sentence-is-pangram/
//
//    A pangram is a sentence where every letter of the English alphabet appears at least once.
//
//    Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
//
//
//
//    Example 1:
//
//    Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//    Output: true
//    Explanation: sentence contains at least one of every letter of the English alphabet.
//    Example 2:
//
//    Input: sentence = "leetcode"
//    Output: false

public class Pangrams {
    public static boolean checkIfPangram(String sentence) {
        if(sentence.length() <26) return false;

        boolean[] aplhabetArr = new boolean[26];

        for (char c: sentence.toCharArray()){

            if('A' <= c && c <= 'Z'){
                aplhabetArr[c - 'A'] = true;
            }
            else if('a' <= c && c <= 'z'){
                aplhabetArr[c - 'a'] = true;
            }
            else continue;
        }

        for(int i=0; i<26;i++){
            if(aplhabetArr[i] == false)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
