package Array.Medium;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }

    public static String removeDuplicatesUsingStack(String s, int k){
        Stack<Pair> stack = new Stack<>();
        char[] charArr = s.toCharArray();

        for (char c:charArr){
            if(!stack.isEmpty() && stack.peek().aChar == c){
                stack.peek().count++;
            }else {
                stack.push(new Pair(c, 1));
            }

            if(stack.peek().count >= k) stack.pop();
        }

        StringBuilder stringAfterRemoval = new StringBuilder();
        for (Pair pair: stack){
            stringAfterRemoval.append(String.valueOf(pair.aChar).repeat(pair.count));
        }

        return stringAfterRemoval.toString();
    }

    static class Pair{
        char aChar;
        int count;

        public Pair(char aChar, int count) {
            this.aChar = aChar;
            this.count = count;
        }
    }
    public static void main(String[] args){
        System.out.println(removeDuplicates("abbbaca", 3));
        System.out.println(removeDuplicatesUsingStack("abbbaca", 3));
    }
}
