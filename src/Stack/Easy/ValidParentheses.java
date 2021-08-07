package Stack.Easy;

import java.util.HashMap;
import java.util.Stack;

//    LeetCode 20. Valid Parentheses https://leetcode.com/problems/valid-parentheses/
//
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//
//    Example 1:
//
//    Input: s = "()"
//    Output: true

public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> bracketsStack = new Stack<>();
        HashMap<Character, Character> charHashMap = new HashMap<>();
        charHashMap.put(')', '(');
        charHashMap.put('}', '{');
        charHashMap.put(']', '[');

        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if(charHashMap.containsKey(c)){
                char topElement = bracketsStack.isEmpty() ? '$' : bracketsStack.pop();

                if(topElement != charHashMap.get(c)) return false;
            }
            else bracketsStack.push(c);
        }

        return bracketsStack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{"));
    }
}
