package Stack;

import java.util.Stack;

public class SortStackRecursion {

    public static Stack SortStack(Stack a) {
        if (!a.empty()) {
            int temp = (int) a.pop();
            SortStack(a);
            sortInserted(a, temp);
        }
        return a;
    }

    public static void sortInserted(Stack stack, int element) {

        if (stack.isEmpty() || element < (int) stack.peek())
            stack.push(element);
        else {
            int temp1 = (int) stack.pop();
            sortInserted(stack, element);
            stack.push(temp1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(-3);
        stack.push(14);
        stack.push(18);
        stack.push(-5);
        stack.push(30);

        stack = SortStackRecursion.SortStack(stack);
        System.out.println("kya lagta hai?");
        stack.forEach(a -> {
            System.out.println(a);
        });
    }
}
