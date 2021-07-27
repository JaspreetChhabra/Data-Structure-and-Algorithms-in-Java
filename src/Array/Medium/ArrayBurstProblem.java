package Array.Medium;

//    LeetCode: https://leetcode.com/discuss/interview-question/625140/Goldman-Sachs-or-OA-2020-or-Array-Burst-Problem-and-Birthday-Party#:~:text=Given%20an%20input%20length%2C%20String,cannot%20be%20shrunk%20any%20further.
//    Array Burst Problem
//
//    Given an input length, String array and burst length(>0) as input,
//    the output should be an array which is a shrunk input array such
//    that the sequentially repeating elements more than or equal to burst
//    length should be removed. This has to be repeated till the array cannot
//    be shrunk any further. Use single characters in the string array for
//    simplicity as shown in sample test cases.
//
//    Input: abcccdeeeeeeeeeeeee
//    Output: abd

import java.util.Stack;

public class ArrayBurstProblem {

    //Using Two pointer
    public static String removeDuplicates1(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            if (i > 0) {
                if (stack[i - 1] == stack[j]){
                    count[i] = count[i - 1] + 1;
                    if(s.length()-1 == j && count[i] >= k) i -= count[i];
                } else {
                    if (count[i - 1] >= k) {
                        i = i - count[i - 1] - 1;
                        j--;
                    } else count[i] = 1;
                }
            } else count[i] = 1;
        }
        return new String(stack, 0, i);
    }

    //Using Stacks
    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (int i=0; i< s.length(); i++){
            if(!stack.isEmpty()){
                if ( stack.peek().aChar == s.charAt(i)) {
                    stack.peek().count++;

                    if(i == s.length()-1 && stack.peek().count >= k) stack.pop();
                } else {
                    if (stack.peek().count >= k) {
                        stack.pop();
                        i--;
                    } else stack.push(new Pair(s.charAt(i), 1));
                }
            }else stack.push(new Pair(s.charAt(i), 1));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Pair c: stack){
            stringBuilder.append(c.aChar);
        }
        return stringBuilder.toString();
    }

    static class Pair{
        char aChar;
        int count;

        public Pair(char aChar, int count) {
            this.aChar = aChar;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaaa",2));
        System.out.println(removeDuplicates1("abcccdee", 2));
        System.out.println(removeDuplicates1("abcccdeeeeeeeeeeeee",3));
    }
}
